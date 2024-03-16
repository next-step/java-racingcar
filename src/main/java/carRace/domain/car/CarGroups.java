package carRace.domain.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroups {

    private final List<Car> carGroups;

    public CarGroups(List<Car> carGroups) {
        this.carGroups = carGroups;
    }

    public CarGroups(final CarNames carNames) {
        this.carGroups = IntStream.range(0, carNames.getCarNames().size())
            .mapToObj(carNumber -> new Car(carNames.getCarNames().get(carNumber)))
            .collect(Collectors.toList());
    }

    public List<Car> getCarGroups() {
        return carGroups;
    }
}
