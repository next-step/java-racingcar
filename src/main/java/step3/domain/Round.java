package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.runType.RunStrategy;

public class Round {

    private List<Integer> results = new ArrayList<>();

    public void start(RacingCars cars, GameSetting gameSetting) {
        RunStrategy runStrategy = gameSetting.getRunStrategy();

        for (Car car : cars.getCars()) {
            car.run(runStrategy);
            results.add(car.getRunDistance());
        }
    }

    public List<Integer> getResults() {
        return results;
    }
}
