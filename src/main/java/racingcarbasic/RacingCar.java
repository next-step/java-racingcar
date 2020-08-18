package racingcarbasic;

public class RacingCar {
    private String name;
    private int step;
    private MoveStrategy moveStrategy;

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public RacingCar(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public void move(int num) {
        if (moveStrategy.move(num))
            step++;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

}
