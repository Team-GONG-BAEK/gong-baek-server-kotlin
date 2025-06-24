package gongbaek.domain.s3

interface S3UploaderPort {
    fun uploadTestFile(): String
    fun listFiles(): List<String>
    fun deleteFile(fileName: String)
}