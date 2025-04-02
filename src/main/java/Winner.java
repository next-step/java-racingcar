import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return cars.stream().map(car -> car.name).collect(Collectors.joining(", "));
    }
}
