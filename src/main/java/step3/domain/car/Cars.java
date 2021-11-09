package step3.domain.car;

import step3.domain.board.RoundBoard;
import step3.domain.power.Engine;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static step3.utils.ValidationUtils.checkArgument;

public class Cars {

    private static final int DEFAULT_LOCATION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkArguments(cars);
        this.cars = cars;
    }

    private void checkArguments(List<Car> cars) {
        checkArgument(cars != null, "cars is required");
    }

    public static Cars of(List<Name> names) {
        checkArgument(names != null, "names is required");
        List<Car> cars = names.stream()
                .map(name -> new Car(Location.placeOn(DEFAULT_LOCATION), name))
                .collect(toList());
        return new Cars(cars);
    }

    public void go(Engine engine) {
        cars.forEach(car -> {
            int power = engine.generatePower();
            car.go(power);
        });
    }

    public void recordRound(RoundBoard roundBoard) {
        checkArgument(cars != null, "roundBoard is required");
        for (Car car : cars) {
            car.record(roundBoard);
        }
    }

    public List<Name> findWinnerNames() {
        Location winnerLocation = findWinnerLocation();
        List<Name> names = cars.stream()
                .filter(car -> car.locationEquals(winnerLocation))
                .map(Car::getName)
                .collect(toList());
        return unmodifiableList(names);
    }

    private Location findWinnerLocation() {
        return cars.stream()
                .sorted(reverseOrder())
                .map(Car::getLocation)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("승자가 없습니다."));

    }

}
