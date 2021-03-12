package study.step3;

import study.step2.StringValidator;

public class CarMoveByNameLengthStrategy implements MoveStrategy{
    private Car car;
    public CarMoveByNameLengthStrategy(Car car){
        this.car = car;
    }
    @Override
    public boolean isMove() {
        return car.getCarName().length() == StringValidator.CAR_NAME_LENGTH_MOVE_CONDITION;
    }
}
