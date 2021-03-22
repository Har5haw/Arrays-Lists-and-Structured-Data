package Assignment_1_One_Key;
public class CaesarCipher {
    private int key;
    private String alphabet;
    private String shiftedAlphabet;

    public CaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.key = key;
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char originalCh = sb.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = shiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    sb.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    sb.setCharAt(i, encryptedCh);
                }
            }
        }
        return sb.toString();
    }

    public String decrypt(String input) {
        KnownLanguageAndKnownKeyLength.CaesarCipher caesarCipher = new KnownLanguageAndKnownKeyLength.CaesarCipher(26 - key);
        return caesarCipher.encrypt(input);
    }
}
