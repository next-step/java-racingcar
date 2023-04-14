package step3;

public class CarStatus {

    private final int position;

    public CarStatus(int position) {
        this.position = position;
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car.getPosition());
    }

    public int getPosition() {
        return position;
    }
}
