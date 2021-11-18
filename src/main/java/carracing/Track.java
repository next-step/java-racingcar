package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Track {
    private final List<Car> cars;

    public Track(int cars) {
        this.cars = new ArrayList<>(cars);
        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Integer> getSteps() {
        return cars.stream()
                .map(Car::getStep)
                .collect(Collectors.toList());
    }

    public void forward() {
        cars.forEach(car -> {
            int random = (int)(Math.random() * 10);
            car.stepForwardByRandomNumber(random);
        });
    }
}
