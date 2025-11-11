package study.racing.view;

import study.racing.domain.Car;
import study.racing.domain.RaceAttempt;
import study.racing.domain.RaceInput;
import study.racing.domain.RandomMoveRule;

import java.util.List;

public class ResultView {

    public static void result(RaceInput raceInput, RaceAttempt attempts) {
        System.out.println("실행 결과");

        for (int i = 0; i < raceInput.getNumberOfAttempt(); i++) {
            playRacing(raceInput, attempts);
            System.out.println();
        }
    }

    private static void playRacing(RaceInput raceInput, RaceAttempt attempts) {
        for (int j = 0; j < raceInput.getNumberOfCars(); j++) {
            if (RandomMoveRule.isRandomNumber()) {
                attempts.getCars().get(j).forwardPosition();
            }
            Car currrentCar = attempts.getCars().get(j);
            System.out.println(currrentCar.getName() + " : " + currrentCar.getPosition());
        }
    }
}
