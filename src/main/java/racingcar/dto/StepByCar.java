package racingcar.dto;

import racingcar.domain.Car;

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

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
