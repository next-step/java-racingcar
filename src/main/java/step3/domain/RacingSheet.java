package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingSheet {

    private final List<Cars> racingSheets = new ArrayList<>();

    public RacingSheet() {
    }

    public void addSheet(Cars cars) {

        Cars snapshot = makeSnapshot(cars);
        racingSheets.add(snapshot);
    }

    private Cars makeSnapshot(Cars cars) {
        List<Car> carsSnapshot = new ArrayList<>();

        for (Car car : cars.getCars()) {
            carsSnapshot.add(new Car(car.getCarName(), car.getMoveDistance()));
        }

        return new Cars(carsSnapshot);
    }

    public List<Cars> getRacingSheets() {
        return racingSheets;
    }
}
