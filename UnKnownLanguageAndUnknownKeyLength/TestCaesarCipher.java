package UnKnownLanguageAndUnknownKeyLength;

/**
 * Write a description of class TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class TestCaesarCipher {
    public void testCaesarCipher() {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();;
        CaesarCipher cc = new CaesarCipher(key);
        String output = cc.encrypt(input);
        System.out.println(output);
        String decrypt = cc.decrypt(output);
        System.out.println(decrypt);
    }

    public void testCaesarCrack() {
        Scanner sc = new Scanner(System.in);
        CaesarCrack cc = new CaesarCrack('e');
        String input = sc.nextLine();
        System.out.println(cc.getKey(input));
    }

    public void testVigenereCipher() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int key[] = new int[len];
        for (int i = 0; i < len; i++) {
            key[i] = sc.nextInt();
        }
        sc.nextLine();
        String input = sc.nextLine();
        VigenereCipher vc = new VigenereCipher(key);
        String output = vc.encrypt(input);
        System.out.println(output);
        System.out.println(vc.decrypt(output));
    }

    public void testSliceString() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int whichSlice = sc.nextInt();
        int totalSlices = sc.nextInt();
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString(input, whichSlice, totalSlices));
    }

    public void testTryKeylen() {
        Scanner sc = new Scanner(System.in);
        FileResource fr = new FileResource("data/athens_keyflute.txt");
        String input = fr.asString();
        int keylength = sc.nextInt();
        VigenereBreaker vb = new VigenereBreaker();
        int[] key = vb.tryKeyLength(input, keylength, 'e');
        for (int i = 0; i < key.length; i++) {
            System.out.println(key[i]);
        }
    }

    public void testBreakVigenere() {
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.breakVigenere());
    }

    public void testReadDictionary() {
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        HashSet < String > dictionary = vb.readDictionary(fr);
        for (String word: dictionary) {
            System.out.println(word);
        }
    }
}