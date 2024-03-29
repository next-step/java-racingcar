package racingcar;

public class Car {
    private CarName carName;
    private int location;

    public Car(String name) throws Exception {
        this.carName = new CarName(name);
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public void move(int distance) {
        location += distance;
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}
