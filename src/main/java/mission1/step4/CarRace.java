package mission1.step4;

import mission1.step4.algorithm.MoveStrategyCache;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;

public class CarRace {

    private CarEntry carEntry;

    private CarRace(CarEntry carEntry) {
        this.carEntry = carEntry;
    }

    public static CarRace getInstance(CarEntry carEntry) {
        return new CarRace(carEntry);
    }

    public CarEntry start() {
        for (Car car : carEntry) {
            car.move(MoveStrategyCache.getMoveByRandomValue());
        }

        return carEntry;
    }
}




