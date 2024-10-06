package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String[] names) {
        List<Car> entry = new ArrayList<>();
        for (String name : names) {
            entry.add(new Car(name));
        }

        this.cars = entry;
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> car.accelerate(random.nextInt(10)));
    }

    public Map<String, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition
                ));
    }
}
