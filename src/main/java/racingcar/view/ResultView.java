package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.Iterator;
import java.util.List;

public class ResultView {
    public static void printCurrentState(Race race) {
        System.out.println(race.getCurrentStateInString());
    }

    public static void printGameOver(Race race) {
        printWinners(race);
    }

    public static void printWinners(Race race) {
        System.out.println(race.getWinnersInString());
    }
}
