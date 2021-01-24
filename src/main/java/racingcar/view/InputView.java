package racingcar.view;

import java.util.Scanner;
import racingcar.util.Constant;
import racingcar.util.InputValidator;

public class InputView {

    public String[] inputCarNames(Scanner scanner) {
        String[] cars;
        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_NAME);
            String carsInput = scanner.next();
            cars = carsInput.split(",");
        } while (!InputValidator.validateCarName(cars));
        return cars;
    }

    public int inputGameTryCnt(Scanner scanner) {
        String inputCnt;
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_TIME);
            inputCnt = scanner.next();
        } while (!InputValidator.validGameCntInput(inputCnt));
        return Integer.parseInt(inputCnt);
    }
}
