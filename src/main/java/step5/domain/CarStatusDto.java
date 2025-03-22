package step5.domain;

public class CarStatusDto {
    private final String carName;
    private final int position;

    public static CarStatusDto of(Car car) {
        return new CarStatusDto(car.getRawName(), car.getRawPosition());
    }

    public CarStatusDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }
}
