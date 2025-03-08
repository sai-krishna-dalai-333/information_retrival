import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TextParser.processFile("ft911_1", "stopwordlist.txt");  // Replace 'your_file_name' with the actual file name
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}