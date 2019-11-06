package racing;

import common.CommonConstant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputCarCountView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public String carName;

    public RacingInputCarCountView(Scanner scanner) {
        carName = inputCarName(scanner);
    }

    private String inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME);
        return validateInputValue(scanner);
    }

    private String validateInputValue(Scanner scanner) {
        try {
            return scanner.next();
        } catch (InputMismatchException e) {
            scanner.close();
            throw new InputMismatchException(CommonConstant.WRONG_INPUT_VALUE);
        }
    }

}
