package step3;

import step3.validation.ValidateRacingCarInput;

import java.util.Scanner;

import static step3.constants.QuestionConstants.HOW_MANY_CARS;
import static step3.constants.QuestionConstants.HOW_MANY_TIMES;

public class RaceInputForm {

    private final Scanner scanner;

    public RaceInputForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public int carsInput() {
        System.out.println(HOW_MANY_CARS);
        int cars = this.scanner.nextInt();

        return ValidateRacingCarInput.positiveNumber(cars);
    }

    public int raceTimeInput() {
        System.out.println(HOW_MANY_TIMES);
        int times = this.scanner.nextInt();

        return ValidateRacingCarInput.positiveNumber(times);
    }
}
