package racingcar_step4;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {

        List<Car> cars = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();

        CarRacingGame carRacingGame = new CarRacingGame(cars);
        cars = carRacingGame.getCars();

        for (int i=0; i < racingCount; i++) {
            cars = carRacingGame.runRacing();
            ResultView.viewRound(cars);
        }

        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winner = racingCarRank.rankCars(cars);
        ResultView.viewRacingCarWinners(winner);
    }
}
