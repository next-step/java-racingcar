package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingController {
    private Racing racing;
    private List<Car> cars;
    private int stages;

    public RacingController(String carNames, int stages) {
        this.cars = Car.asCars(carNames);
        this.stages = stages;
    }

    public void startRacing() {
        this.racing = new Racing(this.cars, stages);
        for (int current = stages; current > 0; --current) {
            racing.race();
            Output.printCurrentCarsState(racing.getCars());
        }
    }

    public void endRacing() {
        Output.printWinners(racing.getCars(), racing.getMaxDistance());
    }
}
