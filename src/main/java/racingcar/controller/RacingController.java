package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;

public class RacingController {
    private Racing racing;
    private ArrayList<Car> carsList;
    private String carNames;
    private int stages;

    public RacingController() {
        initRacing();
    }

    public void initRacing() {
        Output.printInputMessage("경주할 자동차 이름들");
        this.carNames = Input.inputCarsName();
        this.carsList = Car.asCarsList(carNames);

        Output.printInputMessage("시도할 횟수");
        this.stages = Input.inputStages();
    }

    public void startRacing() {
        this.racing = new Racing(this.carsList, stages);
        for (int current = stages; current > 0; --current) {
            racing.race();
            Output.printCurrentCarsState(racing.getCarsList());
        }
    }

    public void endRacing() {
        Output.printWinners(racing.getCarsList(), racing.getMaxDistance());
    }
}
