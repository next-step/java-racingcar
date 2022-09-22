package racing.dto;

import racing.domain.car.Car;

public class CarDto {

    private final int position;

    public CarDto(int position) {
        this.position = position;
    }

    public CarDto() {
        this(0);
    }

    public CarDto(Car car) {
        this(car.position());
    }

    public int position() {
        return position;
    }

    public Car toEntity() {
        return new Car(this.position);
    }
}
