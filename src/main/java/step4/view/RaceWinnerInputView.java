package step4.view;

import step4.view.validation.ValidationInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static step4.constants.QuestionConstants.HOW_MANY_TIMES;
import static step4.constants.QuestionConstants.PUT_CAR_NAMES;

public class RaceWinnerInputView {

    public static List<String> carNameInput(Scanner scanner) {
        System.out.println(PUT_CAR_NAMES);
        String carNames = scanner.nextLine();

        return splitInput(carNames);
    }

    public static int raceTimeInput(Scanner scanner) {
        System.out.println(HOW_MANY_TIMES);
        int times = scanner.nextInt();

        return ValidationInput.positiveNumber(times);
    }

    private static List<String> splitInput(String text) {
        return Arrays.asList(text.split(","));
    }
}
