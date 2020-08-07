package encryptdecrypt;

import java.nio.file.Paths;
import java.util.Scanner;

public class FileReader {

    private String data;

    public FileReader(String file) { data = readFile(file); }

    public String getData() { return data; }

    private String readFile(String file) {

        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(Paths.get(file))) {

            while (scanner.hasNextLine()) {

                sb.append(scanner.nextLine());
            }

        } catch (Exception ignored) {
        }

        return sb.toString();
    }
}
