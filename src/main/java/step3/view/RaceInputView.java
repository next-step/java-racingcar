package step3.view;

import step3.validation.ValidateRacingCarInput;

import java.util.Scanner;

import static step3.constants.QuestionConstants.HOW_MANY_CARS;
import static step3.constants.QuestionConstants.HOW_MANY_TIMES;

public class RaceInputView {

    public static int carsInput(Scanner scanner) {
        System.out.println(HOW_MANY_CARS);
        int cars = scanner.nextInt();

        return ValidateRacingCarInput.positiveNumber(cars);
    }

    public static int raceTimeInput(Scanner scanner) {
        System.out.println(HOW_MANY_TIMES);
        int times = scanner.nextInt();

        return ValidateRacingCarInput.positiveNumber(times);
    }
}
