package step4.dto;

public class Car {
    private Position position;
    private CarName name;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(Car car) {
        this.name = car.name;
        this.position = car.position;
    }

    public void run(RunStrategy runStrategy) {
        if(runStrategy.runnable()) {
            this.position = position.plusPosition();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }
}
