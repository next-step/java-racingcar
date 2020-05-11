package racingcar;

public class Car {
    private int position;
    private final CarMovingCondition carMovingCondition;

    public Car(CarMovingCondition carMovingCondition) {
        this.position = 0;
        this.carMovingCondition= carMovingCondition;
    }

    void tryMove() {
        if(carMovingCondition.canMove()){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
