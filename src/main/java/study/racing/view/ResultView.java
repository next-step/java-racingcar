package study.racing.view;

import study.racing.domain.Car;
import study.racing.domain.RaceAttempt;
import study.racing.domain.RaceInput;
import study.racing.domain.RandomMoveRule;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String WINNER_SEPARATOR = ", ";

    public static void result(RaceInput raceInput, RaceAttempt attempts) {
        System.out.println("실행 결과");

        for (int i = 0; i < raceInput.getNumberOfAttempt(); i++) {
            playRacing(raceInput, attempts);
            System.out.println();
        }

        printWinners(attempts);
    }

    private static void playRacing(RaceInput raceInput, RaceAttempt attempts) {
        for (int j = 0; j < raceInput.getNames().size(); j++) {
            if (RandomMoveRule.isRandomNumber()) {
                attempts.getCars().get(j).forwardPosition();
            }
            Car currrentCar = attempts.getCars().get(j);
            System.out.println(currrentCar.getName() + " : " + currrentCar.getPosition());
        }
    }

    private static void printWinners(RaceAttempt attempts) {
        System.out.println(joinWinnerNames(attempts.topRankCars()).concat("가 최종 우승했습니다."));
    }

    private static String joinWinnerNames(List<Car> winners) {
        List<String> names = new ArrayList<>();

        for (Car winner : winners) {
            names.add(winner.getName());
        }

        return String.join(WINNER_SEPARATOR, names);
    }
}
