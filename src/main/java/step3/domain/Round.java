package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.runType.RunStrategy;

public class Round {


    private List<CarRunResult> carRunResults;

    public Round() {
        this(new ArrayList<>());
    }

    public Round(List<CarRunResult> carRunResults) {
        this.carRunResults = carRunResults;
    }


    public void start(RacingCars cars, GameSetting gameSetting) {
        RunStrategy runStrategy = gameSetting.getRunStrategy();

        for (Car car : cars.getCars()) {
            car.run(runStrategy);
            CarRunResult runResult = new CarRunResult(car.getCarName(), car.getRunDistance());
            carRunResults.add(runResult);
        }
    }

    public List<CarRunResult> getCarRunResults() {
        return carRunResults;
    }
}
