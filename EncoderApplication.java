import java.util.Scanner;

public class EncoderApplication {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the offset character:");
        encoder.setOffset(Character.toUpperCase(scanner.nextLine().charAt(0)));
        System.out.println("Please enter plain text to be encoded:");
        encoder.encode(scanner.nextLine().toUpperCase());
        System.out.println("Please enter encoded text to be decoded:");
        encoder.decode(scanner.nextLine().toUpperCase());
        scanner.close();
    }
}