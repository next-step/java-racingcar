package car;

public class CarStatus {

    private int position;
    private String name;

    private CarStatus(Car car) {
        this.position = car.getPosition();
        this.name = car.getName();
    }

    public static CarStatus from(Car car) {
        return new CarStatus(car);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
