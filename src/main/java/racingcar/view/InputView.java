package racingcar.view;

import racingcar.model.CarNames;
import racingcar.model.Validator;

import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";


    Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }

    public Integer inputNumber() {
        String tryNumber = input();
        Validator.numericCheck(tryNumber);
        Validator.nullCheck(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public CarNames inputCarName() {
        String carNames = input();
        Validator.nullCheck(carNames);

        String[] carNameArray = carNames.split(SEPARATOR);
        Validator.stringRangeCheck(carNameArray);

        return new CarNames(carNameArray);
    }
}
