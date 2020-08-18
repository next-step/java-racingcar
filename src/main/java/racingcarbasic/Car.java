package racingcarbasic;

public class Car {
    private String name;
    private int step;
    private MoveStrategy moveStrategy;

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public Car(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public void move() {
        if (moveStrategy.move())
            step++;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

}
