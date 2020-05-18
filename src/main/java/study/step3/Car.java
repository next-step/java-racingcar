package study.step3;

public class Car {
    private final static int INIT_ZERO = 0;
    private final static int INT_ONE = 1;
    private final int carPosition;

    public Car() {
        this.carPosition = INIT_ZERO;
    }

    public Car(int carPosition) {
        this.carPosition = carPosition;
    }

    public Car move(CarMoveCondition moveCondition){
        if (moveCondition.isCarMoveCondition()){
            return new Car(increasecarPosition());
        }
        return this;
    }

    public int getCarPosition(){
        return carPosition;
    }

    private int increasecarPosition() {
        return carPosition + INT_ONE;
    }
}
