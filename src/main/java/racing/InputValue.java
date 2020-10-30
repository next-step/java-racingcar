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
        return Integer.parseInt(carCount);
    }

    public int setRound() {
        return 0;
    }
}
