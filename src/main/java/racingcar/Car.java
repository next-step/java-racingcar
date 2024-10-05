package racingcar;


public class Car {

    private String status = "";
    private MoveStrategy moveStrategy;

    public String getStatus() {
        return this.status;
    }

    public MoveStrategy getMoveStrategy() {
        return this.moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        if (!moveStrategy.isMove()) {
            return;
        }
        this.status += "-";
    }

}
