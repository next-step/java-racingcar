package racing;

import java.util.Scanner;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public int readCarCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");

        String carCount = scanner.nextLine();
        inputValidator.validate(carCount);

        scanner.close();

        return Integer.parseInt(carCount);
    }

    public int readRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");

        String round = scanner.nextLine();
        inputValidator.validate(round);

        scanner.close();

        return Integer.parseInt(round);
    }
}
