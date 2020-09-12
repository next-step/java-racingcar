package mission1.step4;

import mission1.step4.algorithm.MoveStrategyCache;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

    private List<CarEntry> carRaceResultList = new ArrayList();
    private CarEntry carEntry;

    private CarRace(CarEntry carEntry) {
        this.carEntry = carEntry;
    }

    public static CarRace participate(List<String> carNameList) {
        CarEntry carEntry = new CarEntry();
        carNameList.forEach((name) -> carEntry.regist(Car.create(name)));
        return new CarRace(carEntry);
    }

    public List<CarEntry> start(int execNum) {
        for (int i = 0; i < execNum; i++) {
            racing();
            saveCarRaceResult(carEntry);
        }

        return carRaceResultList;
    }

    public List<Car> getWinningCars() {
        return carEntry.getRaceWinner();
    }

    private void racing() {
        for (Car car : carEntry) {
            car.move(MoveStrategyCache.getMoveByRandomValue());
        }
    }

    private void saveCarRaceResult(CarEntry carEntry) {
        CarEntry currentCarEntry = new CarEntry();

        List<Car> carRaceResult = carEntry.stream()
                                            .map((car) -> car.copy())
                                            .collect(Collectors.toList());

        carRaceResult.forEach((car) -> currentCarEntry.regist(car));

        carRaceResultList.add(currentCarEntry);
    }
}




