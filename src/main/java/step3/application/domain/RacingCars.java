package step3.application.domain;

import step3.application.domain.model.dto.OneMovementLog;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public RacingCars(List<String> names, List<Integer> positions) {
        this.cars = IntStream.range(0, names.size())
                .mapToObj(num -> new Car(names.get(num), positions.get(num)))
                .collect(Collectors.toList());
    }

    public OneMovementLog doRace(MovableGenerator moveFactory) {
        return new OneMovementLog(cars.stream()
                .map(car -> car.move(moveFactory.drawMovable()))
                .collect(Collectors.toList())
        );
    }
}