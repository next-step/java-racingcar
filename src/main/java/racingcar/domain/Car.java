package racingcar.domain;

public class Car {
    public final static int INITIAL_POSITION = 1;
    private int position = INITIAL_POSITION;
    private String name;

    public Car(String name) {
        CarValidator.verifyNameLength(name);
        this.name = name;
    }

    public void moveOrStay(int value) {
        if (MovingForwardCondition.isSatisfied(value)) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
