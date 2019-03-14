package domain;

import lombok.Getter;

public class CarResult {
    @Getter
    private String name;

    @Getter
    private Integer mileage;

    public CarResult(Car car) {
        this.name = car.getName();
        this.mileage = car.getMileage();
    }
}
