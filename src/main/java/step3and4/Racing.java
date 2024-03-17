package step3and4;

import step3and4.car.Car;
import step3and4.car.CarEntry;
import step3and4.car.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int tryNumber;
    private final CarEntry carEntry;

    public static Racing createRacing(String[] carNames, int tryNumber) {
        return new Racing(tryNumber, carNames);
    }

    public Racing(int tryNumber, String[] carNames) {
        this.tryNumber = tryNumber;
        this.carEntry = createCarList(carNames);
    }

    private CarEntry createCarList(String[] carNames) {
        return CarEntry.create(carNames, createCarRandomMoveStrategy());
    }

    private static RandomMoveStrategy createCarRandomMoveStrategy() {
        RandomCreator randomCreator = new RandomCreator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomCreator);
        return randomMoveStrategy;
    }


    public int getCarNumberOfParticipants() {
        return this.carEntry.size();
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public int[] createMoveResult() {
        return carEntry.createMoveResult();
    }

    public void tryMove() {
        carEntry.moveCars();
    }

    public List<String> getNames() {
        return carEntry.getCarNames();
    }

    public List<String> getWinCars() {
        return carEntry.getWinCars();
    }
}
