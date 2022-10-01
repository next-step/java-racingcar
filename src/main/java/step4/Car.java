package step4;

public class Car {

    private CarName carName;
    private int location = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    void moveForward() {
        this.location++;
    }

    public String getCarName(){
        return this.carName.getName();
    }

    public int getLocation() {
        return this.location;
    }
}
