package racingcar.view;

import racingcar.model.Validator;

import java.util.Scanner;

public class InputView {

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Integer inputNumber() {
        String tryNumber = input();
        validator.numericCheck(tryNumber);
        validator.nullCheck(tryNumber);
        return Integer.parseInt(tryNumber);
    }
}
