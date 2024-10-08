package study.racing;

import study.racing.constants.RacingMessage;
import study.racing.domain.Input;
import study.validation.InputValidation;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public Input readInput() {

        System.out.println(RacingMessage.CAR_COUNT.getMsg());
        String carCount = scanner.nextLine();

        System.out.println(RacingMessage.TRY_COUNT.getMsg());
        String roundCount = scanner.nextLine();

        int car = 0;
        int round = 0;

        boolean isInputMatch = InputValidation.racingInputValidation(carCount, roundCount);
        if(isInputMatch) {
            car = Integer.parseInt(carCount);
            round = Integer.parseInt(roundCount);
        }
        return new Input(car, round);
    }

    public Input readWinnerInput() {

        System.out.println(RacingMessage.CAR_NAME.getMsg());
        String carName = scanner.nextLine();

        System.out.println(RacingMessage.TRY_COUNT.getMsg());
        String roundCount = scanner.nextLine();

        int round = 0;
        Input input = null;
        boolean isInputMatch = InputValidation.racingInputValidationForNames(carName, roundCount);
        if(isInputMatch) {
            String[] carNames = carName.trim().split(",");
            round = Integer.parseInt(roundCount);
            input = new Input(carNames, carNames.length, round);
        }
        return input;
    }
}
