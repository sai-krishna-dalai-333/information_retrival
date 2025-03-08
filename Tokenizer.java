import java.util.*;
// import java.util.regex.*;
import java.util.stream.*;

public class Tokenizer {
    public static List<String> tokenize(String text) {
        // Remove numbers and split on non-alphanumeric characters
        String[] tokens = text.split("\\W+");
        // Convert to lower case and filter out tokens with numbers
        return Arrays.stream(tokens)
                .map(String::toLowerCase)
                .filter(token -> !token.matches(".*\\d.*"))
                .collect(Collectors.toList());
    }
}