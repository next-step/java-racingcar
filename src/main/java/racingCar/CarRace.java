package racingCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CarRace {
    private final List<Car> cars;
    private final Random random;

    public CarRace(String names) {
        random = new Random();
        cars = new ArrayList<>();

        allocateCars(split(names));
    }
    private String[] split(String names) {
        return names.split(",");
    }

    private void allocateCars(String[] names) {
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void play() {
        for (Car car : this.cars) {
            car.move(getRandomNum());
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int max = getMaxDistance();

        for(Car car : cars) {
            if(car.getDistance() == max) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getRandomNum() {
        return random.nextInt(10);
    }
    private int getMaxDistance() {
        int max = 0;
        for(Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        return max;
    }
}
