package racingcar.domain;

import java.util.List;

public class CarRacing {
    private int times;
    private RacingCars racingCars;

    public CarRacing(int times, String inputNames) throws Exception {
        this.times = times;
        this.racingCars = new RacingCars(inputNames);
    }

    public List<Car> run() {
        return racingCars.run();
    }

}
