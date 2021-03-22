package Assignment_2_Caesar_Cipher_Two_Keys_Decrypt;

public class Driver {
    public static void main(String[] args) {
        CaesarBreaker caesarBreaker = new CaesarBreaker();
        System.out.println(caesarBreaker.decryptTwoKeys("tftftftftftf"));
    }
}
