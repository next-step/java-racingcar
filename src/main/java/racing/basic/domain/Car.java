package racing.basic.domain;

public class Car {

    private final static int FORWARD_CONDITION = 4;
    private final static int OIL = 1;

    private int fuel;

    protected void moveOrStop(int diceNumber) {
        if(FORWARD_CONDITION <= diceNumber) {
            fuel += OIL;
        }
    }

    protected int getDrivingDistance() {
        return fuel;
    }
}
