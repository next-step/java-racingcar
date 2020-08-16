package racingcarbasic;

public class RacingCar {
    String name;
    int step;
    private MoveStrategy moveStrategy;

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
