package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CarRacing {

    private static final String LOCATION_TOKEN = "-";
    private final List<Car> cars;
    private final int racingCount;

    private final RandomFactory randomFactory;

    public CarRacing(int carCounts, int racingCount, RandomFactory randomFactory) {
        this.cars = initCars(carCounts);
        this.racingCount = racingCount;
        this.randomFactory = randomFactory;
    }

    private List<Car> initCars(int carCounts) {
        return IntStream.range(0, carCounts).mapToObj(x -> new Car()).collect(Collectors.toUnmodifiableList());
    }

    public List<List<String>> startRacing() {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < racingCount; i++) {
            result.add(step());
        }
        return result;
    }

    private List<String> step() {
        return cars.stream()
                .map(car -> convertText(car.run(randomFactory.getNextInt())))
                .collect(Collectors.toList());
    }

    private String convertText(int level) {
        return LOCATION_TOKEN.repeat(level);
    }
}
