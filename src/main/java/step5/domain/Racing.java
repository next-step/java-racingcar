package step5.domain;

import step5.domain.car.CarEntry;
import step5.domain.car.move.random.RandomMoveStrategy;
import step5.domain.car.move.random.RandomCreator;

import java.util.List;

public class Racing {
    private final int tryNumber;
    private final CarEntry carEntry;

    public static Racing createRacing(String[] carNames, int tryNumber, RandomMoveStrategy randomMoveStrategy) {
        return new Racing(tryNumber, carNames, randomMoveStrategy);
    }

    public Racing(int tryNumber, String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        this.tryNumber = tryNumber;
        this.carEntry = createCarList(carNames, randomMoveStrategy);
    }

    private CarEntry createCarList(String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        return CarEntry.create(carNames, randomMoveStrategy);
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
