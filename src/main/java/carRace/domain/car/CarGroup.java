package carRace.domain.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroup {

    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public CarGroup(final CarNames carNames) {
        this.carGroup = IntStream.range(0, carNames.getCarNames().size())
            .mapToObj(carNumber -> new Car(carNames.getCarNames().get(carNumber)))
            .collect(Collectors.toList());
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
