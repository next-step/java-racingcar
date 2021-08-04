package stage3;

public class CarService {
    private Car car;

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
}