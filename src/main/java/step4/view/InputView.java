package step4.view;


import step4.dto.Competition;

import java.util.Scanner;

import static step4.TextConstant.QUESTION_HOW_MANY_CAR;
import static step4.TextConstant.QUESTION_HOW_MANY_ROUND;


public class InputView {

    public Competition eventStart() {
        int paticipateCount = inputPaticipate();
        int racingRound = inputRacingRound();

        return Competition.create(paticipateCount,racingRound);
    }

    public int inputPaticipate() {
        System.out.println(QUESTION_HOW_MANY_CAR);
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        return carCount;
    }

    public int inputRacingRound() {
        System.out.println(QUESTION_HOW_MANY_ROUND);
        Scanner scanner = new Scanner(System.in);
        int roundCount = scanner.nextInt();

        return roundCount;
    }

}
