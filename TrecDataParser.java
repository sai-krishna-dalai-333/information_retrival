import java.util.*;
import java.util.regex.*;

public class TrecDataParser {
    public static List<Document> parseTrecData(String fileContent) {
        List<Document> parsedDocuments = new ArrayList<>();
        String[] documents = fileContent.split("</DOC>");
        Pattern docNoPattern = Pattern.compile("<DOCNO>(.*?)</DOCNO>");
        for (String doc : documents) {
            Matcher matcher = docNoPattern.matcher(doc);
            if (matcher.find()) {
                String docId = matcher.group(1).trim();
                String docText = doc.replaceAll("<.*?>", "");  // Remove all tags
                parsedDocuments.add(new Document(docId, docText));
            }
        }
        return parsedDocuments;
    }
}