package model;


public class Car {


    private final CarName carName;
    private int currentPosition = 0;


    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car carWithName(CarName carName) {
        return new Car(carName);
    }

    public void move() {
        this.currentPosition++;
    }

    public boolean isSamePosition(int position) {
        return this.currentPosition == position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public CarName getCarName() {
        return carName;
    }


}
