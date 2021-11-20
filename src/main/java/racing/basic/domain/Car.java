package racing.basic.domain;

import com.sun.org.apache.xpath.internal.operations.Number;

public class Car {

    private final static int FORWARD_CONDITION = 4;
    private final static int ONE = 1;

    private int position;

    protected void moveOrStop(int diceNumber) {
        if(FORWARD_CONDITION <= diceNumber) {
            position += ONE;
        }
    }

    protected int getDrivingDistance() {
        return position;
    }
}
