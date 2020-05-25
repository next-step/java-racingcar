package racingcar_step4;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame();

        String[] names = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();

        List<Car> cars = carRacingGame.createCars(names);

        for (int i=0; i < racingCount; i++) {
            cars = carRacingGame.runRacing();
            ResultView.viewRound(cars);
        }

        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winner = racingCarRank.rankCars(cars);
        ResultView.viewRacingCarWinners(winner);
    }
}
