import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TextParser {

    public static void processFile(String inputFile, String stopwordFile) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(inputFile)));

        // Parse TREC data to separate documents
        List<Document> parsedDocuments = TrecDataParser.parseTrecData(fileContent);

        // Initialize dictionaries and token streams
        List<String> allTokens = new ArrayList<>();
        List<String> documentIds = new ArrayList<>();

        for (Document doc : parsedDocuments) {
            List<String> tokens = Tokenizer.tokenize(doc.getText());
            tokens = StopwordEliminator.eliminateStopwords(tokens, stopwordFile);
            allTokens.addAll(tokens);
            documentIds.add(doc.getId());
        }

        Map<String, Integer> wordDict = DictionaryBuilder.buildWordDictionary(allTokens);
        Map<String, Integer> fileDict = DictionaryBuilder.buildFileDictionary(documentIds);

        // Write output to parser_output.txt
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("parser_output.txt"))) {
            for (Map.Entry<String, Integer> entry : wordDict.entrySet()) {
                writer.write(entry.getKey() + "\t\t" + entry.getValue() + "\n");
            }
            writer.write("\n");
            for (Map.Entry<String, Integer> entry : fileDict.entrySet()) {
                writer.write(entry.getKey() + "\t\t" + entry.getValue() + "\n");
            }
        }
    }
}