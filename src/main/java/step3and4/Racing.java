package step3and4;

import step3and4.car.Car;
import step3and4.car.CarFirstCollection;
import step3and4.car.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int tryNumber;
    private final CarFirstCollection carFirstCollection;

    public static Racing createRacing(String[] carNames, int tryNumber) {
        return new Racing(tryNumber, carNames);
    }

    public Racing(int tryNumber, String[] carNames) {
        this.tryNumber = tryNumber;
        this.carFirstCollection = createCarList(carNames);
    }

    private CarFirstCollection createCarList(String[] carNames) {
        return CarFirstCollection.from(createCarList(carNames, createCarRandomMoveStrategy()));
    }

    private static RandomMoveStrategy createCarRandomMoveStrategy() {
        RandomCreator randomCreator = new RandomCreator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomCreator);
        return randomMoveStrategy;
    }

    private static List<Car> createCarList(String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(createCar(randomMoveStrategy, carNames[i]));
        }
        return cars;
    }

    private static Car createCar(RandomMoveStrategy randomMoveStrategy, String carNames) {
        return new Car(carNames, randomMoveStrategy);
    }

    public int getCarNumberOfParticipants() {
        return this.carFirstCollection.size();
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

    public String[] getNames() {
        return carFirstCollection.getCarNames();
    }

    public String[] getWinCars() {
        return carFirstCollection.getWinCars();
    }
}
