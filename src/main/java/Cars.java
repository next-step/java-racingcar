import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars{
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList.stream().map(x -> new Car(x.getName(), x.getPosition())).collect(Collectors.toList());
    }

    public Cars(Cars cars) {
        this(cars.getCars());
    }

    public void move() {
        this.cars.forEach(car -> car.moveBy(RandomNumberUtil.getRandomNumberFromZeroToNine()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getMaxPosition() {
        final Optional<Integer> maxPosition = this.cars.stream().map(Car::getPosition).max(Comparator.comparing(Integer::valueOf));
        if (maxPosition.isPresent()) {
            return maxPosition.get();
        }
        throw new IllegalArgumentException();
    }

    public String getNames() {
        return this.cars.stream().map(Car::getName).collect(Collectors.joining(","));
    }

    public List<Car> getByPosition(int position) {
        return this.cars.stream().filter(car -> car.isPosition(position)).collect(Collectors.toList());
    }
}
