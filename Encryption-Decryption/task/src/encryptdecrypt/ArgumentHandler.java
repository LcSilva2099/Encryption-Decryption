package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class ArgumentHandler {

    Map<String, String> arguments;

    public ArgumentHandler(String[] args) {

        arguments = new HashMap<>();
        separateArguments(args);
    }

    private void separateArguments(String[] args) {

        for (int i = 0; i < args.length; i += 2) {

            arguments.put(args[i], args[i + 1]);
        }
    }

    public String getMode() {
        return arguments.getOrDefault("-mode", "enc");
    }

    public int getKey() { return Integer.parseInt(arguments.getOrDefault("-key", "0")); }

    public String getData() {

        if (arguments.containsKey("-data")) {

            return arguments.getOrDefault("-data", "");
        }

        FileReader fileReader = new FileReader(arguments.get("-in"));

        return fileReader.getData();
    }

    public String getOut() {
        return arguments.getOrDefault("-out", null);
    }

    public String getAlg() { return arguments.getOrDefault("-alg", "shift"); }
}
