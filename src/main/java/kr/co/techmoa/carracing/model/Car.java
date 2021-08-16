package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;

public class Car {

    private static final int ADVENCE_LIMIT = 4;

    private Position position;
    private CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
        position = new Position(0);
    }

    public Car move(boolean isMove) {
        if(isMove)
            this.position = position.plus();
        return this;
    }

    public boolean moveOperator(MoveStategy moveStategy) {
        int operatorSu = moveStategy.move();
        return isAdvence(operatorSu);
    }

    private boolean isAdvence(int operator) {
        if(operator < ADVENCE_LIMIT) {
            return Move.REVERSE.isCarMove();
        }
        return Move.ADVANCE.isCarMove();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Position getPosition() {
        return position;
    }
}
