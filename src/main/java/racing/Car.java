package racing;

public class Car {

    private CarLocation carLocation;

    public Car(CarLocation carLocation) {
        this.carLocation = carLocation;
    }

    public CarLocation getCarLocationInfo() {
        return this.carLocation;
    }

}
