import scala.io.Source
import java.text.Normalizer
import java.text.Normalizer.Form
import scala.util.matching.Regex




object count {
    def main(args: Array[String]) {
      val file = Source.fromFile("data/data.txt")
      var text = file.mkString
      var wordsMap = new scala.collection.mutable.HashMap[String, Int]

      val keyValPattern: Regex = "\\w+".r
      text = Normalizer.normalize(text, Form.NFD)
      text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase
      var words = keyValPattern.findAllMatchIn(text)
      for(word<-words){
            if(wordsMap.contains(word.toString()))
              wordsMap(word.toString()) += 1
            else
              wordsMap(word.toString()) = 0

      }
      print(wordsMap)
    }

}
