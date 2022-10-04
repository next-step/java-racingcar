package racing_car_with_winner.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final CarNameInput carNameInput;

    public CarFactory(CarNameInput carNameInput) {
        this.carNameInput = carNameInput;
    }

    public List<Car> build() {
        return Arrays.stream(carNameInput.parse())
                     .map(CarName::new)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }
}
