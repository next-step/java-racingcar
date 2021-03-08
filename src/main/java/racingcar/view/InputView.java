package racingcar.view;

import racingcar.utils.InputValidator;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int InputNumberOfCars() {
        System.out.println(INPUT_HOW_MANY_CARS);
        String number = scanner.nextLine().trim();
        InputValidator.validateNull(number);
        InputValidator.validateEmpty(number);
        InputValidator.validateInteger(number);
        InputValidator.validateLessThanZero(number);
        return Integer.parseInt(number);
    }
}
