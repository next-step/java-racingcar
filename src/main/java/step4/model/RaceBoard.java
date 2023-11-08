package step4.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceBoard {

    private final List<String> carNames;

    public RaceBoard(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<Car> generate() {
        return this.carNames.stream()
                .map(Car::new).collect(Collectors.toList());
    }
}
