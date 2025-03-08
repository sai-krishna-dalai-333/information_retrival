import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StopwordEliminator {
    public static List<String> eliminateStopwords(List<String> tokens, String stopwordFile) throws IOException {
        Set<String> stopWords = new HashSet<>(Files.readAllLines(Paths.get(stopwordFile)));
        return tokens.stream()
                .filter(token -> !stopWords.contains(token))
                .collect(Collectors.toList());
    }
}