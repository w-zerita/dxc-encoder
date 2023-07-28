import java.util.ArrayList;
import java.util.Arrays;

public class Encoder {

    public static final ArrayList<Character> CHARACTERS = new ArrayList<Character>(
            Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
            'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', 
            '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', 
            ',', '-', '.', '/' ));

    private char offset;

    public char getOffset() { return offset; }
    public void setOffset(char offset) { this.offset = offset; }

    public String encode(String plainText) {
        int shift = CHARACTERS.indexOf(offset);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(offset);
        for(int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            int currentIndex = CHARACTERS.indexOf(currentChar);
            if(currentIndex == -1) {
                stringBuilder.append(currentChar);
            } else {
                int newIndex = currentIndex - shift;
                if(newIndex < 0) {
                    newIndex += CHARACTERS.size();
                }
                stringBuilder.append(CHARACTERS.get(newIndex));
            }
        }
        String encodedText = stringBuilder.toString();
        System.out.println("Encoded Text: " + encodedText);
        return encodedText;
    }

    public String decode(String encodedText) {
        offset = encodedText.charAt(0);
        int shift = CHARACTERS.indexOf(offset);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i < encodedText.length(); i++) {
            char currentChar = encodedText.charAt(i);
            int currentIndex = CHARACTERS.indexOf(currentChar);
            if(currentIndex == -1) {
                stringBuilder.append(currentChar);
            } else {
                int newIndex = currentIndex + shift;
                if(newIndex >= CHARACTERS.size()) {
                    newIndex -= CHARACTERS.size();
                }
                stringBuilder.append(CHARACTERS.get(newIndex));
            }
        }
        String plainText = stringBuilder.toString();
        System.out.println("Decoded Text: " + plainText);
        return plainText;
    }
}