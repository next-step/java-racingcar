package racing;

import java.util.Scanner;

public class InputValue {

    private final InputValidator inputValidator;

    public InputValue() {
        this.inputValidator = new InputValidator();
    }

    public int setCarCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");

        String carCount = scanner.nextLine();
        inputValidator.validate(carCount);

        scanner.close();

        return Integer.parseInt(carCount);
    }

    public int setRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");

        String round = scanner.nextLine();
        inputValidator.validate(round);

        scanner.close();

        return Integer.parseInt(round);
    }
}
