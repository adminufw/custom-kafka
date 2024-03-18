import java.nio.file.{Files, Paths}
import scala.collection.JavaConverters._

object FileSystemReader {
    def main(args: Array[String]): Unit = {
        val dataPath = "./data"

        val files    = listFiles(dataPath)

        files.foreach(println)
    }

    def listFiles(dataPath: String): List[String] = {
        try {
            val paths = Files.list(Paths.get(dataPath)).iterator().asScala.toList

            paths.map(_.toString)
        } catch {
            case e: Exception => {
                println(s"Error listing files: ${e.getMessage}")
                List.empty[String]
            }
        }
    }
}