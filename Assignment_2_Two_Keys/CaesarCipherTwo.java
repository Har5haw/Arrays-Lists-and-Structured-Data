package Assignment_2_Two_Keys;


public class CaesarCipherTwo {
    private String alphabets;
    private String shiftedAlphabets1;
    private String shiftedAlphabets2;
    private int key1;
    private int key2;

    public CaesarCipherTwo(int key1, int key2){
        this.alphabets = "abcdefghijklmnopqrstuvwxyz";
        this.shiftedAlphabets1 = alphabets.substring(key1) + alphabets.substring(0, key1);
        this.shiftedAlphabets2 = alphabets.substring(key2) + alphabets.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encrypt(String input){
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i = 0; i < stringBuilder.length(); i+=2) {
            char originalCh = stringBuilder.charAt(i);
            int idx = alphabets.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = shiftedAlphabets1.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    stringBuilder.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    stringBuilder.setCharAt(i, encryptedCh);
                }
            }
        }
        for (int i = 1; i < stringBuilder.length(); i+=2) {
            char originalCh = stringBuilder.charAt(i);
            int idx = alphabets.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = shiftedAlphabets2.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    stringBuilder.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    stringBuilder.setCharAt(i, encryptedCh);
                }
            }
        }

        return stringBuilder.toString();
    }

    public String decrypt(String input){
        CaesarCipherTwo caesarCipherTwo = new CaesarCipherTwo(26 - key1, 26 - key2);
        String decrypt = caesarCipherTwo.encrypt(input);
        return decrypt;
    }


}
