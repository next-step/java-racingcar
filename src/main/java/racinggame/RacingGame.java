package racinggame;

import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public int carsCount() {
        return this.cars.size();
    }

    public void play() {
        for(Car car : cars) {
            car.move();
        }
    }

    public List<Car> cars() {
        return this.cars;
    }

}
