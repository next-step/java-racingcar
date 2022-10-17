package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public final class Game {

    private final PositiveNumber carNo;
    private final PositiveNumber tryNo;
    private PositiveNumber tryCount;
    private final Cars cars;

    public Game(final String carNo, final String tryNo) {
        this.carNo = new PositiveNumber(carNo);
        this.tryNo = new PositiveNumber(tryNo);
        this.tryCount = PositiveNumber.ONE;
        this.cars = new Cars(mapToCarList(this.carNo));
    }

    private static List<Car> mapToCarList(final PositiveNumber carNo) {
        final List<Car> cars = new ArrayList<>();
        for (PositiveNumber i = PositiveNumber.ONE;
            i.isLessThanOrEquals(carNo);
            i = i.plus(PositiveNumber.ONE)) {
            cars.add(CarFactory.getDefaultCar());
        }
        return cars;
    }

    public void play() {
        if (isGameOver()) {
            return;
        }
        cars.move();
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount = tryCount.plus(PositiveNumber.ONE);
    }

    public boolean isGameOver() {
        return tryCount.isGreaterThan(tryNo);
    }

    public List<Distance> getCarDistances() {
        return cars.getDistances();
    }

}
