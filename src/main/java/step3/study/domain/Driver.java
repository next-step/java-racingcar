package step3.study.domain;

public class Driver {
    private final String name;
    private final Car car;

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void moveCar(int number) {
        car.move(number);
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return car.getDistance();
    }

    public String getNameAndNowPosition() {
        return this.name + " : " + car.getDistance();
    }
}
