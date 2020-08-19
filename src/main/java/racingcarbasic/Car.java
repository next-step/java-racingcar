package racingcarbasic;

public class Car {
    private final String name;
    private int step;
    private MoveStrategy moveStrategy;

    public Car(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void move() {
        if (moveStrategy.move())
            step++;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

}
