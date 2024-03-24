package racinggame.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    private CarNumber tryNo;

    public RacingGame(String carNames, int tryNo) {
        this(carNames, new CarNumber(tryNo));
    }

    public RacingGame(String carNames, CarNumber tryNo) {
        this(new Cars(carNames), tryNo);
    }

    public RacingGame(Cars cars, CarNumber tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public void race() {
        this.tryNo.decrease();
        this.cars.race();
    }

    public boolean racing() {
        return this.tryNo.isPositive();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
