package encryptdecrypt;

class UnicodeMethod extends EncDecMethod {

    public UnicodeMethod(String data) {
        super(data);
    }

    @Override
    public String encrypt(int key) {
        return transformMessage(key);
    }

    @Override
    public String decrypt(int key) { return transformMessage(key - key * 2); }

    public String transformMessage(int key) {

        for (int i = 0; i < finalMessage.length(); i++) {

            for (int j = 0; j <= 127; j++) {

                if ((char) j == finalMessage.charAt(i)) {

                    int ascII = j + key;

                    if (ascII > 127) {

                        ascII -= 127;

                        finalMessage.setCharAt(i, (char) ((char)ascII - 1));

                        break;
                    }

                    finalMessage.setCharAt(i, (char)ascII);

                    break;
                }
            }
        }

        return finalMessage.toString();
    }
}
