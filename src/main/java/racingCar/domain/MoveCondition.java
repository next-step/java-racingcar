package racingCar.domain;

public class MoveCondition {
    public static final int FORWARD_BOUNDARY_VALUE = 3;

    int condition;

    private MoveCondition(int num) {
        this.condition = num;
    }

    public static MoveCondition of(int num) {
        return new MoveCondition(num);
    }

    public boolean isMovable(){
        return condition > FORWARD_BOUNDARY_VALUE;
    }
}
