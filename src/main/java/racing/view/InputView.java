package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racing.view.ViewConstant.ATTEMPT_MESSAGE;
import static racing.view.ViewConstant.CAR_MESSAGE;

/**
 * @author han
 */
public class InputView {
    private List<String> users;
    private int attempts;

    public List<String> getUsers() {
        return users;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void printAndInput(Scanner scanner) {
        System.out.println(CAR_MESSAGE);
        this.users = Arrays.asList(scanner.nextLine().split(","));

        System.out.println(ATTEMPT_MESSAGE);
        this.attempts = parseInputToInteger(scanner.nextLine());
    }

    private int parseInputToInteger(String input) {
        return Integer.parseInt(input);
    }
}
