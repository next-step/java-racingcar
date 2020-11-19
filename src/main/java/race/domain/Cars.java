package race.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(EngineFactory factory, List<String> carNames) {
        if(carNames.size() <= 0) throw new IllegalArgumentException("carNames");

        cars = carNames.stream()
                .map(name -> new Car(factory.createEngine(), name))
                .collect(Collectors.toUnmodifiableList());
    }

    public LapScores lap() {
        return new LapScores(cars.stream()
                .map(Car::run)
                .collect(Collectors.toUnmodifiableList()));
    }

}
