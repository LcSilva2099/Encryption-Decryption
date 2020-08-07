package encryptdecrypt;

public abstract class EncDecMethod {

    final StringBuilder finalMessage;

    public EncDecMethod(String data) { finalMessage = new StringBuilder(data); }

    abstract String encrypt(int key);

    abstract String decrypt(int key);
}
