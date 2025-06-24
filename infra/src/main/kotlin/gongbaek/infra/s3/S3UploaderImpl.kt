package gongbaek.infra.s3

import com.amazonaws.services.s3.AmazonS3
import gongbaek.domain.s3.S3UploaderPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class S3UploaderImpl(
    private val amazonS3: AmazonS3,
    @Value("\${cloud.aws.s3.bucket}")
    private val bucketName: String
) : S3UploaderPort {

    override fun uploadTestFile(): String {
        val content = "Hello S3! Test at " + LocalDateTime.now()
        val fileName = "test-${System.currentTimeMillis()}.txt"

        amazonS3.putObject(bucketName, fileName, content)
        return fileName
    }

    override fun listFiles(): List<String> {
        return amazonS3.listObjects(bucketName)
            .objectSummaries
            .map { it.key }
    }

    override fun deleteFile(fileName: String) {
        amazonS3.deleteObject(bucketName, fileName)
    }
}
