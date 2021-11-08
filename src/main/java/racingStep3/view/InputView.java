package racingStep3.view;

import racingStep3.domain.GameInputData;
import racingStep3.service.Validation;

import java.util.Scanner;

public class InputView {

    public  GameInputData getRacingCarInput() {
        int carCount = getCarCount();
        int tryCount = getTryCount();

        return GameInputData.of(carCount, tryCount);
    }

    private int getCarCount() {
        return inputData("자동차 대수는 몇 대 인가요?");
    }

    private int getTryCount() {
        return inputData("시도할 회수는 몇 회 인가요?");
    }

    public static int inputData(String msg) {
        System.out.println(msg);

        Scanner scanner = new Scanner(System.in);
        String inValue = scanner.nextLine();
        checkValue(inValue);

        return Integer.parseInt(inValue);
    }

    private static void checkValue(String value) {
        Validation.numberCheck(value);
        Validation.validInputData(value);
    }

}
