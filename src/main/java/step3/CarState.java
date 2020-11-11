package step3;

public class CarState {

    private Car car;

    public static CarState of(Car car) {
        return new CarState(car);
    }

    private CarState(Car car) {
        this.car = car;
    }

    public Car getCar(){ return car; }

    public String getName() {
        return car.name;
    }

    public int getMovingDistance() {
        return car.movingDistance;
    }
}
