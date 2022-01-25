package racinggame.domain;

public class Car {

    private static final int GO_POSSIBLE_VALUE = 4;

    private final String carName;
    private int location = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getLocation() {
        return location;
    }

    public void updateLocation(int location) {
        this.location = location;
    }

    public String getCarName() {
        return carName;
    }

    public void move(Integer integer) {
        if (integer >= GO_POSSIBLE_VALUE){
            location++;
        }
    }
}
