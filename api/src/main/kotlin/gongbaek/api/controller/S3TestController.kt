package gongbaek.api.controller

import gongbaek.domain.s3.S3UploaderPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/s3")
class S3TestController(
    private val s3Uploader: S3UploaderPort
) {

    @Value("\${cloud.aws.s3.bucket}")
    private lateinit var bucketName: String

    @PostMapping("/test-upload")
    fun testUpload(): ResponseEntity<String> {
        return try {
            val fileName = s3Uploader.uploadTestFile()
            ResponseEntity.ok("업로드 성공: $fileName")
        } catch (e: Exception) {
            ResponseEntity.status(500).body("업로드 실패: ${e.message}")
        }
    }

    @GetMapping("/test-list")
    fun listFiles(): ResponseEntity<List<String>> {
        return try {
            ResponseEntity.ok(s3Uploader.listFiles())
        } catch (e: Exception) {
            ResponseEntity.status(500).body(listOf("조회 실패: ${e.message}"))
        }
    }

    @DeleteMapping("/test-delete/{fileName}")
    fun deleteFile(@PathVariable fileName: String): ResponseEntity<String> {
        return try {
            s3Uploader.deleteFile(fileName)
            ResponseEntity.ok("삭제 성공: $fileName")
        } catch (e: Exception) {
            ResponseEntity.status(500).body("삭제 실패: ${e.message}")
        }
    }
}
