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
    private String plainText;
    private String encodedText;
    
    public char getOffset() { return offset; }
    public void setOffset(char offset) { this.offset = offset; }
    public String getPlainText() { return plainText; }
    public void setPlainText(String plainText) { this.plainText = plainText; }
    public String getEncodedText() { return encodedText; }
    public void setEncodedText(String encodedText) { this.encodedText = encodedText; }
    
    public Encoder() {}

    public Encoder(char offset, String plainText) {
        this.offset = offset;
        this.plainText = plainText;
        this.encodedText = encode(plainText);
    }
    
    public Encoder(String encodedText) {
        this.encodedText = encodedText;
        this.offset = encodedText.charAt(0);
        this.plainText = decode(encodedText);
    }

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
        return stringBuilder.toString();
    }

    public String decode(String encodedText) {
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
        return stringBuilder.toString();
    }
}