package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingController {
    private Racing racing;
    private List<Car> cars;
    private String carNames;
    private int stages;

    public RacingController() {
        initRacing();
    }

    public void initRacing() {
        Output.printInputMessage("경주할 자동차 이름들");
        this.carNames = Input.inputCarsName();
        this.cars = Car.asCars(carNames);

        Output.printInputMessage("시도할 횟수");
        this.stages = Input.inputStages();
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
