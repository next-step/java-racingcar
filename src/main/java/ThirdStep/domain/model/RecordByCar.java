package ThirdStep.domain.model;

public class RecordByCar {
    private final Car car;
    private final int location;

    public RecordByCar(Car car, int location) {
        this.car = car;
        this.location = location;
    }

    public Car getCar() {
        return car;
    }

    public int getLocation() {
        return location;
    }

}
