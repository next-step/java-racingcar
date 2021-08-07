package stage4;

public class CarService {
    private final Car car;

    public CarService(Car car) {
        this.car = car;
    }

    public int getCondition() {
        return this.car.getForwardCondition();
    }

    public int tryForward(int condition) {
        if (this.car.isForward(condition)) this.car.forward();
        return this.car.getStatus();
    }

    public int getStatus() {
        return this.car.getStatus();
    }

    public Car getCar() {
        return this.car;
    }
}