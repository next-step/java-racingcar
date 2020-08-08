package step4.view;


import step4.dto.Competition;

import java.util.Scanner;

import static step4.TextConstant.*;


public class InputView {

    private final String SPECIAL_CHARACTER_FOR_SPLIT = ",";

    public Competition eventStart() {
        String paticipateCarNames = inputPaticipateNames();
        String[] splitCarNames = splitCarNames(paticipateCarNames);

        int racingRound = inputRacingRound();

        return Competition.create(splitCarNames,racingRound);
    }

    private String[] splitCarNames(String cars){
        String[] carNames = cars.split(SPECIAL_CHARACTER_FOR_SPLIT);
        return carNames;
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
