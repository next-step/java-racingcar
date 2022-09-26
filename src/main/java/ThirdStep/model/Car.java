package ThirdStep.model;

public class Car {

    private static final int START_LOCATION = 0;
    private int location;
    private String name;

    public Car() {
        this.location = START_LOCATION;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public static Car of(CarRequest carRequest) {
        Car car = new Car();
        car.setName(carRequest.getName());
        return car;
    }
}
