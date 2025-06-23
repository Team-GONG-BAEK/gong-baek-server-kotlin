package gongbaek.api.controller

import com.amazonaws.services.s3.AmazonS3
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/s3")
class S3TestController(
    val amazonS3: AmazonS3
) {

    @Value("\${cloud.aws.s3.bucket}")
    private lateinit var bucketName: String

    @PostMapping("/test-upload")
    fun testUpload(): ResponseEntity<String> {
        return try {
            val content = "Hello S3! Test at " + LocalDateTime.now()
            val fileName = "test-${System.currentTimeMillis()}.txt"

            amazonS3.putObject(bucketName, fileName, content)

            ResponseEntity.ok("파일 업로드 성공!")
        } catch (e: Exception) {
            ResponseEntity.status(500)
                .body("upload faill")
        }
    }

    @GetMapping("/test-list")
    fun listFiles(): ResponseEntity<List<String>> {
        return try {
            val fileNames = amazonS3.listObjects(bucketName)
                .objectSummaries
                .map { it.key }

            ResponseEntity.ok(fileNames)
        } catch (e: Exception) {
            ResponseEntity.status(500)
                .body(listOf("조회 실패: ${e.message}"))
        }
    }

    @DeleteMapping("/test-delete/{fileName}")
    fun deleteFile(@PathVariable fileName: String): ResponseEntity<String> {
        return try {
            amazonS3.deleteObject(bucketName, fileName)
            ResponseEntity.ok("파일 삭제 성공: $fileName")
        } catch (e: Exception) {
            ResponseEntity.status(500)
                .body("삭제 실패: ${e.message}")
        }
    }
}
