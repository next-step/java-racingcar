package carracing.domain;

import java.util.List;

public class RacingGame {
    private static Cars cars;
    private int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> getCars(){
        return this.cars.getCarList();
    }

    public boolean remainTryCount() {
        return this.tryCount > 0;
    }

    public void racing() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        cars.racing(numberGenerator);
        reduceTryCount();
    }

    public void reduceTryCount() {
        tryCount--;
    }

    public List<Car> getWinners(){
        return cars.getWinners();
    }
}
