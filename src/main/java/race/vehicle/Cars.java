package race.vehicle;

import race.Utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String INITIAL_LOCATION = "-";
    private final List<Car> cars = new ArrayList<>();

    RandomGenerator randomGenerator = RandomGenerator.getRandomGenerator();

    public Cars(int num) {
        if(num < 2){
            throw new IllegalArgumentException("게임을 진행할 수 없음");
        }
        initCars(num);
    }

    Cars initCars(int num) {
        for (int i = 0; i < num; i++) {
            cars.add(new Car.Builder().initlocation(INITIAL_LOCATION).initRandomUtil(randomGenerator).build());
        }
        return this;
    }

    public List<Car> getCars() {
        return cars;
    }
}
