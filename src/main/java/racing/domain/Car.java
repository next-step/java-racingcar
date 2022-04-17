package racing.domain;

import racing.util.ForwardUtil;

public class Car {

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void move(int value)
    {
        this.distance += getDistance(value);
    }

    private int getDistance(int value) {
        if(ForwardUtil.isAvailableForward(value)) {
            return 1;
        }
        return 0;
    }
}
