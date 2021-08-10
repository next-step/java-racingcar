package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final Cars cars;
    private int tryCount;
    private final RacingSheet racingSheet;

    public CarRacing(String carNameString, int tryCount) {
        this.cars = new Cars(initCars(carNameString));
        this.tryCount = tryCount;
        this.racingSheet = new RacingSheet();
    }

    private List<Car> initCars(String carNameString) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNameString.split(",");

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Cars> racingGameStart() {

        while (tryCount > 0) {
            cars.racing();
            racingSheet.addSheet(cars);
            tryCount--;
        }

        return racingSheet.getRacingSheets();
    }

    public List<Car> extractWinner() {
        return cars.extractWinner();
    }

}
