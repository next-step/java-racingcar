import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameSettings getGameSettings() {
        String inputCarNames = prompt("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = inputCarNames.split(",");
        int roundCount = promptInt("시도할 회수는 몇 회 인가요?");
        return new GameSettings(carNames, roundCount);
    }

    private String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
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
