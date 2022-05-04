package racingCar.domains;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String names) {
        this.cars = new ArrayList<>();
        for (String name : names.split(",")) {
            this.cars.add(new Car(name));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> findWinners() {
        int max = maxPosition();
        return winners(max);
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : this.cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<Car> winners(int max) {
        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isWinner(max)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
