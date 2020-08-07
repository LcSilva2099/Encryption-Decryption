package encryptdecrypt;

import java.io.IOException;
import java.io.PrintWriter;

public class EncoderDecoder {

    private EncDecMethod encDecMethod;
    private ArgumentHandler argumentHandler;
    private String data;

    public EncoderDecoder(ArgumentHandler argumentHandler) {
        this.argumentHandler = argumentHandler;
        data = argumentHandler.getData();
        encDecMethod = algChoice(argumentHandler.getAlg());
    }

    public String encrypt() { return encDecMethod.encrypt(argumentHandler.getKey()); }

    public String decrypt() { return encDecMethod.decrypt(argumentHandler.getKey()); }

    protected EncDecMethod algChoice(String alg) {

        if ("unicode".equals(alg)) {

            return new UnicodeMethod(data);
        }

        return new ShiftMethod(data);
    }

    public void start() {

        if (argumentHandler.getOut() == null) {

            if ("dec".equals(argumentHandler.getMode())) {

                System.out.println(decrypt());

            } else {

                System.out.println(encrypt());
            }

        } else {

            if ("dec".equals(argumentHandler.getMode())) {

                data = decrypt();

            } else {

                data = encrypt();
            }

            try (PrintWriter printWriter = new PrintWriter(argumentHandler.getOut())) {

                printWriter.print(data);

            } catch (IOException e) {

                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
    }
}
