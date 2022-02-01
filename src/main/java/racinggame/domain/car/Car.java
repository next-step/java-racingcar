package racinggame.domain.car;

import racinggame.domain.random.GoRule;

public class Car {

    private final String carName;
    private int location;

    public Car(String carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }

    public void move(GoRule goRule) {
        if (goRule.isGo()) {
            location++;
        }
    }

}
