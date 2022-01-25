package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.view.OutputView;

public class Game {

    private final Cars cars;

    public Game(final Cars cars) {
        this.cars = cars;
    }

    public void play(MovableStrategy strategy) {
        for (Car car: cars.get()) {
            car.run(strategy);
            OutputView.printDistance(car);
        }
        System.out.println();
    }


}
