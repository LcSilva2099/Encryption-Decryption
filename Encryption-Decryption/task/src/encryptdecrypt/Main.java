package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        ArgumentHandler argumentHandler = new ArgumentHandler(args);
        EncoderDecoder encoderDecoder = new EncoderDecoder(argumentHandler);

        encoderDecoder.start();
    }
}


