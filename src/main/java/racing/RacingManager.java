package racing;

import racing.generator.NumberGenerator;

import java.util.List;

public class RacingManager {
    private List<Car> cars;
    private NumberGenerator numberGenerator;
    private int count;

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator, int count) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
        this.count = count;
    }

    public RacingManager() {
    }

    public boolean isMovable(int value) {
        return 4 <= value && value <= 9;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextStep() {
        for (Car car : cars) {
            car.goForward(isMovable(numberGenerator.generate()));
        }
    }

    public List<Car> getWinners() {
        return null;
    }
}
