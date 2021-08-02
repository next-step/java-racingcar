package CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private Random random = new Random();

    public Cars(String carNames) {
        Arrays.asList(carNames.split(",")).forEach(s -> cars.add(new Car(new CarName(s))));

    }

    public void moveAll() {
        cars.forEach(s -> s.move(random.nextInt(10)));
    }

    public List<Car> getCars() {
        return cars;
    }
}