package racing.basic.domain;

public class Car {

    private final static int BIFURCATION = 4;
    private final static int OIL = 1;

    private int fuel;

    protected void moveOrStop(int diceNumber) {
        if(BIFURCATION <= diceNumber) {
            fuel += OIL;
        }
    }

    protected int getDrivingDistance() {
        return fuel;
    }
}
