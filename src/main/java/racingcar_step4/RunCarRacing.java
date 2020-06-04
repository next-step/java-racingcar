package racingcar_step4;

import racingcar_step4.domain.Cars;
import racingcar_step4.model.Car;
import racingcar_step4.model.MovingStrategy;
import racingcar_step4.model.RandomMovingStrategy;
import racingcar_step4.view.InputView;
import racingcar_step4.view.ResultView;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {

        List<Car> cars = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();

        Cars racingCar = new Cars(cars);
        cars = racingCar.getCars();

        MovingStrategy movingStrategy = new RandomMovingStrategy();

        for (int i=0; i < racingCount; i++) {
            cars = racingCar.runRacing(movingStrategy);
            ResultView.viewRound(cars);
        }

        List<Car> winner = racingCar.rankCars(cars);
        ResultView.viewRacingCarWinners(winner);
    }
}
