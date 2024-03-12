package step3and4;

import step3and4.car.Car;
import step3and4.car.CarFirstCollection;
import step3and4.car.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int carNumber;
    private final int tryNumber;
    private final CarFirstCollection carFirstCollection;

    public static Racing createRacing(int carNumber, int tryNumber) {
        return new Racing(carNumber, tryNumber);
    }

    public Racing(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
        this.carFirstCollection = createCarList(carNumber);
    }

    private CarFirstCollection createCarList(int carNumber) {
        RandomCreator randomCreator = new RandomCreator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomCreator);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(randomMoveStrategy));
        }
        return CarFirstCollection.from(cars);
    }


    public int getCarNumberOfParticipants() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public int[] createMoveResult() {
        return carFirstCollection.createMoveResult();
    }

    public void tryMove() {
        carFirstCollection.moveCars();
    }
}
