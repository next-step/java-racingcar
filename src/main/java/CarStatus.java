public class CarStatus {

    private final String name;
    private final int position;

    public CarStatus(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
} 