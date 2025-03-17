import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public int promptInt(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number!");
            System.out.println(message);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
