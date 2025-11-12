package racingCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CarRace {
    private final List<Car> cars;
    private final Random random;

    public  CarRace(int cnt) {
        random = new Random();
        cars = new ArrayList<>();
        allocateCars(cnt);
    }
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

    private void allocateCars(int cnt) {
        for (int i = 0; i < cnt; i++) {
            this.cars.add(new Car());
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
    
    private int getRandomNum() {
        return random.nextInt(10);
    }
}
