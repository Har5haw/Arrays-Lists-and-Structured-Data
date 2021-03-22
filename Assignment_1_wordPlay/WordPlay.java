package Assignment_1_wordPlay;

public class WordPlay {
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder stringBuilder = new StringBuilder(phrase);
        for(int i=0;i<stringBuilder.length();i++){
            if(isVowel(stringBuilder.charAt(i)))
            stringBuilder.setCharAt(i, ch);
        }
        return  stringBuilder.toString();
    }

    public String emphasize(String phrase, char ch){
        StringBuilder stringBuilder = new StringBuilder(phrase);
        for(int i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i) == ch){
                if(i%2 == 0){
                    stringBuilder.setCharAt(i, '*');
                }else{
                    stringBuilder.setCharAt(i, '+');
                }
            }
        }
        return stringBuilder.toString();
    }
}
