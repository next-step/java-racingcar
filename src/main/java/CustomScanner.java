import java.util.Scanner;

public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] scanInputCarNames() {
        String inputLine = scanner.nextLine();

        if (inputLine.isEmpty()) {
            return null;
        }
        return inputLine.split(",");
    }

    public static int scanMoveCount() {
        return scanner.nextInt();
    }
}
