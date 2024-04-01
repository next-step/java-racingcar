package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private int times;
    private RacingCars racingCars;

    public CarRacing(int times, String inputNames) throws Exception {
        this.times = times;
        this.racingCars = new RacingCars(inputNames);
    }

    public List<List<Car>> run() {
        List<List<Car>> results = new ArrayList<>();
        for (int i = 0; i < this.times; i++) {
            results.add(racingCars.roundRun());
        }
        return results;
    }
}
