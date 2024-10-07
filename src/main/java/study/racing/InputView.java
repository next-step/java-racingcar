package study.racing;

import study.racing.constants.RacingMessage;
import study.racing.domain.Input;
import study.validation.InputValidation;

import java.util.Scanner;

public class InputView {

    public Input readInput() {
        Scanner scanner = new Scanner(System.in);

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
}
