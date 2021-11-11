package racing.view;

import racing.NumberHelper;

import java.util.Scanner;

import static racing.ViewConstant.ATTEMPT_MESSAGE;
import static racing.ViewConstant.CAR_MESSAGE;

/**
 * @author han
 */
public class InputView {
    private int cars;
    private int attempts;

    public Integer getCars() {
        return cars;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void printAndInput(Scanner scanner) {
        System.out.println(CAR_MESSAGE);
        this.cars = parseInputToInteger(scanner.nextLine());

        System.out.println(ATTEMPT_MESSAGE);
        this.attempts = parseInputToInteger(scanner.nextLine());
    }

    private int parseInputToInteger(String input) {
        return Integer.parseInt(input);
    }
}
