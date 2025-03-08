import java.util.*;
// import java.util.stream.*;

public class DictionaryBuilder {
    public static Map<String, Integer> buildWordDictionary(List<String> tokens) {
        Porter stemmer = new Porter();
        Map<String, Integer> wordDict = new HashMap<>();
        int tokenId = 1;
        for (String token : tokens) {
            String stemmedToken = stemmer.stripAffixes(token);
            if (!wordDict.containsKey(stemmedToken)) {
                wordDict.put(stemmedToken, tokenId++);
            }
        }
        return wordDict;
    }

    public static Map<String, Integer> buildFileDictionary(List<String> fileNames) {
        Map<String, Integer> fileDict = new HashMap<>();
        for (int i = 0; i < fileNames.size(); i++) {
            fileDict.put(fileNames.get(i), i + 1);
        }
        return fileDict;
    }
}