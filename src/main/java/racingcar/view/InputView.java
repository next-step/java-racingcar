package racingcar.view;

import racingcar.model.CarNames;
import racingcar.model.Validator;

import java.util.Scanner;

public class InputView {

    private final Validator validator;
    private static final String SEPARATOR = ",";


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

    public CarNames inputCarName() {
        String carNames = input();
        validator.nullCheck(carNames);

        String[] carNameArray = carNames.split(SEPARATOR);
        validator.stringRangeCheck(carNameArray);

        return new CarNames(carNameArray);
    }
}
