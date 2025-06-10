package gongbaek.server.controller

import com.amazonaws.services.s3.AmazonS3Client
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/s3")
class S3TestController(
    val amazonS3: AmazonS3Client
) {

    @Value("\${cloud.aws.s3.bucket}")
    private lateinit var bucketName: String

    @PostMapping("/test-upload")
    fun  testUpload() : ResponseEntity<String> {
        return try{
            var content = "Hello S3! Test at " + LocalDateTime.now()
            var fileName = "test-${System.currentTimeMillis()}.txt"

            val fileUrl = amazonS3.putObject(bucketName, fileName, content)

            ResponseEntity.ok("파일 업로드 성공! : $fileUrl")
        }catch (e: Exception){
            ResponseEntity.status(500)
                .body("upload faill")
        }
    }

    @GetMapping("/test-list")
    fun listFiles(): ResponseEntity<List<String>>{
        return try{
            val fileNames = amazonS3.listObjects(bucketName)
                .objectSummaries
                .map { it.key }

            ResponseEntity.ok(fileNames)
        }catch (e: Exception){
            ResponseEntity.status(500)
                .body(listOf("조회 실패: ${e.message}}"))
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