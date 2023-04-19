package study.step3.domain;

public class Car {

    public static final int GO = 1;
    private int position;
    private String name;
    private MoveConditionStrategy moveConditionStrategy;

    public Car(String name, MoveConditionStrategy moveConditionStrategy) {
        this.position = 0;
        this.name = name;
        this.moveConditionStrategy = moveConditionStrategy;
    }

    public void moveForward() {
        if (moveConditionStrategy.isPossible()) {
            position += GO;
        }
    }

    public boolean isEqualsPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
