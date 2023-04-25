package race;

public class CarResult {
    private String carName;
    private int position;

    public CarResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public static CarResult from(Car car) {
        return new CarResult(
                car.getCarName().getCarName(),
                car.getPosition().getPosition()
        );
    }
}
