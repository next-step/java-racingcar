package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racing.constant.ViewConstant.ATTEMPT_MESSAGE;
import static racing.constant.ViewConstant.CAR_MESSAGE;

/**
 * @author han
 */
public class InputView {

    public List<String> getUsers(Scanner scanner) {
        System.out.println(CAR_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public Integer getAttempts(Scanner scanner) {
        System.out.println(ATTEMPT_MESSAGE);
        return parseInputToInteger(scanner.nextLine());
    }

    private int parseInputToInteger(String input) {
        return Integer.parseInt(input);
    }
}
