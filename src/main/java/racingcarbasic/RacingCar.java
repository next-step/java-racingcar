package racingcarbasic;

public class RacingCar {
    private MoveStrategy moveStrategy;
    String name;
    int step;

    public RacingCar(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public void move(int num) {
        if(moveStrategy.move(num))
            step++;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

}
