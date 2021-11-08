package racing;

import java.util.Scanner;

/**
 * @author han
 */
public class InputView {
    private String carMessage = "자동차 대수는 몇 대 인가요?";
    private String attemptMessage = "시도할 회수는 몇 회 인가요?";

    private int cars;
    private int attempts;

    public Integer getCars() {
        return cars;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void printAndInput(Scanner scanner) {
        System.out.println(this.carMessage);
        this.cars = parseInputToInteger(scanner.nextLine());

        System.out.println(this.attemptMessage);
        this.attempts = parseInputToInteger(scanner.nextLine());
    }

    private int parseInputToInteger(String input) {
        int parseInt = Integer.parseInt(input);
        if (NumberHelper.isLessThanOne(parseInt)) {
            throw new IllegalArgumentException();
        }
        return parseInt;
    }
}
