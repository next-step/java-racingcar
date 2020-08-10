package step4.view;


import step4.dto.Competition;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static step4.TextConstant.*;


public class InputView {

    private final String SPECIAL_CHARACTER_FOR_SPLIT = ",";

    public Competition eventStart() {
        String paticipateCarNames = inputPaticipateNames();
        List<String> splitCarNames = splitCarNames(paticipateCarNames);

        int racingRound = inputRacingRound();

        return Competition.create(splitCarNames,racingRound);
    }

    private List<String> splitCarNames(String cars){

        return Arrays.asList(cars.split(SPECIAL_CHARACTER_FOR_SPLIT));
    }

    private String inputPaticipateNames() {
        System.out.println(QUESTION_WHAT_IS_NAME_THE_CAR);
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();

        return carNames;
    }

    private int inputRacingRound() {
        System.out.println(QUESTION_HOW_MANY_ROUND);
        Scanner scanner = new Scanner(System.in);
        int roundCount = scanner.nextInt();

        return roundCount;
    }

}
