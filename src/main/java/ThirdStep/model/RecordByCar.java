package ThirdStep.model;

public class RecordByCar {
    private Car car;
    private int location;

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
