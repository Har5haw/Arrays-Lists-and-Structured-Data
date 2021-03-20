package UnKnownLanguageAndUnknownKeyLength;

/**
 * Write a description of class VigenereCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VigenereCipher {
    int[] key;
    CaesarCipher[] ccList;

    public VigenereCipher(int[] key) {
        this.key = key;
        ccList = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ccList[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder sbInput = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            String ch = sbInput.substring(i, i + 1);
            ch = ccList[i % (key.length)].encrypt(ch);
            sbInput.setCharAt(i, ch.charAt(0));
        }
        return sbInput.toString();
    }

    public String decrypt(String input) {
        StringBuilder sbInput = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            String ch = sbInput.substring(i, i + 1);
            ch = ccList[i % (key.length)].decrypt(ch);
            sbInput.setCharAt(i, ch.charAt(0));
        }
        return sbInput.toString();
    }
}