package step3.domain.car;

import step3.domain.board.CarSnapshot;
import step3.domain.power.Engine;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static step3.utils.ValidationUtils.checkArgument;

public class Cars {

    public static final int DEFAULT_LOCATION = 0;

    private final List<Car> cars;

    public static Cars of(List<Name> names) {
        checkArgument(names != null, "names is required");
        List<Car> cars = names.stream()
                .map(name -> new Car(Location.placeOn(DEFAULT_LOCATION), name))
                .collect(toList());
        return new Cars(cars);
    }

    public Cars(List<Car> cars) {
        checkArguments(cars);
        this.cars = cars;
    }

    private void checkArguments(List<Car> cars) {
        checkArgument(cars != null, "cars is required");
    }

    public List<CarSnapshot> go(Engine engine) {
        List<CarSnapshot> carSnapshots = cars.stream()
                .map(car -> {
                    int power = engine.generatePower();
                    return car.go(power);
                })
                .collect(toList());
        return unmodifiableList(carSnapshots);
    }

    public Winners findWinners() {
        Location winnerLocation = findWinnerLocation();
        List<Car> winners = cars.stream()
                .filter(car -> car.locationEquals(winnerLocation))
                .collect(toList());
        return new Winners(winners);
    }

    private Location findWinnerLocation() {
        return cars.stream()
                .sorted(reverseOrder())
                .map(Car::getLocation)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("승자가 없습니다."));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
