package racingcar.view;

import racingcar.model.Validator;

import java.util.Scanner;

public class InputView {

    private final Validator validator;

    Scanner scanner = new Scanner(System.in);

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String input() {
        return scanner.nextLine();
    }

    public Integer inputNumber() {
        String tryNumber = input();
        validator.numericCheck(tryNumber);
        validator.nullCheck(tryNumber);
        return Integer.parseInt(tryNumber);
    }
}
