import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameSettings getGameSettings() {
        int carCount = promptInt("자동차 대수는 몇 대 인가요?");
        int roundCount = promptInt("시도할 회수는 몇 회 인가요?");
        return new GameSettings(carCount, roundCount);
    }

    private int promptInt(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number!");
            System.out.println(message);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
