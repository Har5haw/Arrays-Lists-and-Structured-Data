package UnKnownLanguageAndUnknownKeyLength;

public class CaesarCrack
{
    char commonChar;
    
    public CaesarCrack(char commonChar){
        this.commonChar = commonChar;
    }
    
    public int getKey(String input){
        int key = 0;
        int maxCountCommonChar = 0;
        for(int i=1; i<=26; i++){
            CaesarCipher cc = new CaesarCipher(i);
            String output = cc.decrypt(input);
            int countCommonChars = 0;
            for(int j = 0; j < output.length();j++){
                if(output.charAt(j) == commonChar){
                     countCommonChars++;   
                }
            }
            if(countCommonChars > maxCountCommonChar){
                maxCountCommonChar = countCommonChars;
                key = i;
            }
        }
        return key;  
    }
}
