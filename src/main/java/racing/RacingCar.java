package racing;

import racing.domain.Car;
import racing.domain.RacingCarGame;
import racing.domain.RacingCarRank;
import racing.view.RacingCarView;

import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        try {
            doRacing(RacingCarView.getCarNames(), RacingCarView.getRoundCount());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void doRacing(String[] names, int roundCnt) {
        //레이싱
        RacingCarGame racingCarGame = new RacingCarGame();
        List<Car> cars = racingCarGame.createCars(names);
        racingCarGame.startRacing(roundCnt);

        //랭킹
        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winners = racingCarRank.rankCars(cars);
        RacingCarView.viewRacingCarWinners(winners);
    }
}
