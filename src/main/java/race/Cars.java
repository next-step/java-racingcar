package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(int count) {
        List<Car> entry = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            entry.add(new Car(i));
        }
        this.cars = entry;
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> car.accelerate(random.nextInt(10)));
    }

    public Map<Integer, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getId,
                        Car::getPosition
                ));
    }
}
