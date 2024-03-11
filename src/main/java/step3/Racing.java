package step3;

import step3.car.Car;
import step3.car.CarList;
import step3.car.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int carNumber;
    private final int tryNumber;
    private final CarList carList;
    private static final RandomCreator randomCreator = new RandomCreator();

    public static Racing createRacing(int carNumber, int tryNumber) {
        return new Racing(carNumber, tryNumber);
    }

    public Racing(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
        this.carList = createCarList(carNumber);
    }

    private CarList createCarList(int carNumber) {
        RandomCreator randomCreator = new RandomCreator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomCreator);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(randomMoveStrategy));
        }
        return CarList.from(cars);
    }


    public int getCarNumberOfParticipants() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public int[] createMoveResult() {
        return carList.createMoveResult();
    }

    public void tryMove() {
        carList.moveCars();
    }
}
