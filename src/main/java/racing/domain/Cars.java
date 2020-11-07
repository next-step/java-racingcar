package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int vehicleCount) {
        this.cars = new ArrayList<>(vehicleCount);

        for(int i = 0; i<vehicleCount; i += 1) {
            cars.add(new Car(String.valueOf(i)));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moves() {
        cars.stream()
                .peek(Car::move)
                .collect(Collectors.toList());
    }

}
