package domain;

public class Car {
    private CarState carState;
    private final CarDisplacement carDisplacement;

    private Car(CarState carState, CarDisplacement carDisplacement) {
        this.carState = carState;
        this.carDisplacement = carDisplacement;
    }

    private Car(Car car) {
        this(car.getCarState(), car.getCarDisplacement());
    }

    public static Car createCar(CarState carState, CarDisplacement carDisplacement) {
        return new Car(carState, carDisplacement);
    }

    public static Car createCopy(Car car) {
        return new Car(car);
    }

    public void move() {
        carState = carState.move(carDisplacement);
    }

    public int getPosition() {
        return carState.position();
    }

    private CarState getCarState() {
        return carState.copy();
    }

    public CarDisplacement getCarDisplacement() {
        return carDisplacement;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return this.carState.equals(car.carState);
    }

    @Override
    public String toString() {
        return carState.toString();
    }
}
