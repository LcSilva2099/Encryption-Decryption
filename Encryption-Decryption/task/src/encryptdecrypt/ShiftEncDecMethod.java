package encryptdecrypt;

class ShiftMethod extends EncDecMethod {

    public ShiftMethod(String data) {
        super(data);
    }


    @Override
    String encrypt(int key) {

        for (int i = 0; i < finalMessage.length(); i++) {

            if (Character.isUpperCase(finalMessage.charAt(i))) {

                char ch = (char) (((int) finalMessage.charAt(i) + key - 65) % 26 + 65);

                finalMessage.setCharAt(i, ch);

            } else if(finalMessage.charAt(i) >= 97 && finalMessage.charAt(i) <= 122){

                char ch = (char) (((int) finalMessage.charAt(i) + key - 97) % 26 + 97);

                finalMessage.setCharAt(i, ch);
            }
        }

        return finalMessage.toString();
    }

    @Override
    String decrypt(int key) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        char[] lower = alphabet.toCharArray();
        char[] upper = alphabet.toUpperCase().toCharArray();

        for (int i = 0; i < finalMessage.length(); i++) {

            if (Character.isUpperCase(finalMessage.charAt(i))) {

                for (int j = 0; j < upper.length; j++) {

                    if (j >= key && finalMessage.charAt(i) == upper[j]) {

                        finalMessage.setCharAt(i, upper[j - key]);

                        break;
                    }

                    if (finalMessage.charAt(i) == upper[j] && j < key) {

                        finalMessage.setCharAt(i, upper[(upper.length - key + 1) + j]);

                        break;
                    }
                }
            } else if (Character.isLowerCase(finalMessage.charAt(i))) {

                for (int j = 0; j < lower.length; j++) {

                    if (j >= key && finalMessage.charAt(i) == lower[j]) {

                        finalMessage.setCharAt(i, lower[j - key]);

                        break;
                    }

                    if (finalMessage.charAt(i) == lower[j] && j < key) {

                        finalMessage.setCharAt(i, lower[(lower.length - key) + j]);

                        break;
                    }
                }
            }
        }

        return finalMessage.toString();
    }
}
