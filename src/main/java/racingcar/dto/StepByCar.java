package racingcar.dto;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class StepByCar {

    private final String name;
    private final int position;

    private StepByCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static StepByCar of(Car car) {
        return new StepByCar(car.getName(), car.getPosition());
    }

    public static List<StepByCar> of(Cars cars) {
        return of(cars.getCars());
    }

    public static List<StepByCar> of(List<Car> car) {
        return car.stream().map(StepByCar::of)
                .collect(Collectors.toList());
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
