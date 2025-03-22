import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> move() {
        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }
}
