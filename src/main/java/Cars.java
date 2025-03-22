import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(int carNum) {
        this.cars = Stream.generate(Car::new).limit(carNum).collect(Collectors.toList());
    }

    public Cars(Cars cars) {
        this.cars = cars.cars.stream().map(Car::new).collect(Collectors.toList());
    }

    public void move() {
        this.cars.forEach(car -> car.moveBy(RandomNumberUtil.getRandomNumberFromZeroToNine()));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
