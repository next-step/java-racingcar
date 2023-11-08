package step4.view;

import step4.view.validation.ValidationInput;

import java.util.List;
import java.util.Scanner;

import static step4.constants.QuestionConstants.*;

public class RaceWinnerInputView {

    public static List<String> carNameInput(Scanner scanner) {
        System.out.println(PUT_CAR_NAMES);
        String carNames = scanner.nextLine();

        return ValidationInput.verifyInputLength(carNames);
    }

    public static int raceTimeInput(Scanner scanner) {
        System.out.println(HOW_MANY_TIMES);
        int times = scanner.nextInt();

        return ValidationInput.positiveNumber(times);
    }
}
