package racinggame.domain.car;

import racinggame.domain.random.GoRule;

public class Car {

    private final String carName;
    private int location;

    public Car(final String carName, final int location) {
        this.carName = carName;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }

    public void move(final GoRule goRule) {
        if (goRule.isGo()) {
            location++;
        }
    }

    public boolean isInLocation(int location) {
        return this.location == location;
    }
}
