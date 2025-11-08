package study.racing.view;

import study.racing.domain.RaceInput;
import study.racing.domain.RandomMoveRule;

import java.util.List;

public class ResultView {

    private static final String MARK = "-";

    public void result(RaceInput raceInput, List<String> attempts) {
        System.out.println("실행 결과");

        for (int i = 0; i < raceInput.getNumberOfAttempt(); i++) {
            playRacing(raceInput, attempts);
            System.out.println();
        }
    }

    private static void playRacing(RaceInput raceInput, List<String> attempts) {
        for (int j = 0; j < raceInput.getNumberOfCars(); j++) {
            if (RandomMoveRule.isRandomNumber()) {
                attempts.set(j, attempts.get(j) + MARK);
            }
            System.out.println((j + 1) + "번 차량 : " + attempts.get(j));
        }
    }
}
