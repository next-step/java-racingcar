package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    private NamesAsCars namesAsCars;
    private final TryNo tryNo;

    public RacingGame(String carNames, int tryNo) {
        this(carNames, new TryNo(tryNo));
    }

    public RacingGame(String carNames, TryNo tryNo) {
        this(new NamesAsCars(carNames), tryNo);
    }

    public RacingGame(NamesAsCars namesAsCars, TryNo tryNo) {
        this.namesAsCars = namesAsCars;
        this.tryNo = tryNo;
    }

    public RacingGame(String carNames, TryNo tryNo) {
        this.cars = CarsFactory.cars(carNames);
        this.tryNo = tryNo;
    }

    public void race() {
        tryNo.race();
        this.cars = namesAsCars.cars();
        moveCars();
    }

    private void moveCars() {
        cars.move();
    }

    public boolean racing() {
        return tryNo.racing();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
