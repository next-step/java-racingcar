package step5.domain;

public class CarDto {

    private final int position;

    private final String carName;

    public CarDto(Car car) {
        this.position = car.getPosition();
        this.carName = car.getCarName();
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

}
