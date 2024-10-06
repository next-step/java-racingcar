package carracing.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class Cars {
    private static final Random RANDOM = new Random();
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move() {
        for (Car car : this.cars) {
            car.move(RANDOM.nextInt(10));
        }
    }

    public Cars getCarsSamePositionAs(int maxPosition) {
         return new Cars(this.cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList())
         );
    }

    public Cars deepCopy() {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : this.cars) {
            copiedCars.add(car.deepCopy());
        }
        return new Cars(copiedCars);
    }

    public List<Car> get() {
        return this.cars;
    }

    public int compareMax(int maxPosition) {
        for(Car car : this.cars) {
            maxPosition = car.compareMax(maxPosition);
        }
        return maxPosition;
    }
}
