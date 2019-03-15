package racing.application;

import racing.domain.Car;
import racing.domain.RacingCarGame;
import racing.domain.RacingCarRank;
import racing.view.ConsoleView;

import java.util.List;

public class ConsoleApplication {

    public static void main(String[] args) {
        try {
            doRacing(ConsoleView.getCarNames(), ConsoleView.getRoundCount());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void doRacing(String[] names, int roundCnt) {
        //레이싱
        RacingCarGame racingCarGame = new RacingCarGame();
        List<Car> cars = racingCarGame.createCars(names);
        for (int i = 0; i < roundCnt; i++) {
            cars = racingCarGame.startRound();
            ConsoleView.viewRound(cars);
        }

        //랭킹
        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winners = racingCarRank.rankCars(cars);
        ConsoleView.viewRacingCarWinners(winners);
    }
}
