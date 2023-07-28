import java.util.Scanner;

public class EncoderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the offset character:");
        char offset = Character.toUpperCase(scanner.nextLine().charAt(0));
        System.out.println("Please enter plain text to be encoded:");
        String plainText = scanner.nextLine().toUpperCase();
        Encoder encoder = new Encoder(offset, plainText);
        System.out.println("Encoded Text: " + encoder.getEncodedText());

        System.out.println("Please enter encoded text to be decoded:");
        String encodedText = scanner.nextLine().toUpperCase();
        Encoder decoder = new Encoder(encodedText);
        System.out.println("Decoded Text: " + decoder.getPlainText());
        scanner.close();
    }
}