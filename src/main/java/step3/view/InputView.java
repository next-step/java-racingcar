package step3.view;

import java.util.Arrays;
import java.util.Scanner;
import step3.util.ViewConstant;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int enterCarCount() {
        System.out.println(ViewConstant.ENTER_CAR_COUNT);
        return scanner.nextInt();
    }

    public int enterRoundCount() {
        System.out.println(ViewConstant.ENTER_ROUND_COUNT);
        return scanner.nextInt();
    }

    public String enterCarName() {
        System.out.println(ViewConstant.ENTER_CAR_NAME);
        return scanner.nextLine();
    }

    public void validateCarName(String[] names, int limit) {
        Arrays.stream(names)
            .filter(name -> name.length() > limit)
            .findAny()
            .ifPresent(present -> {
                throw new IllegalArgumentException();
            });
    }

    public String[] splitInput(String input) {
        return input.split(ViewConstant.DELIMITER);
    }
}