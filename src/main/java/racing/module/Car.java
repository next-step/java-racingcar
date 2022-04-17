package racing.module;

import exception.CustomException;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private CarName carName;
    private int position;

    private Car() throws CustomException {
        throw new CustomException("자동차의 이름없이 생성이 불가능합니다.");
    }

    public Car(String carName) throws CustomException {
        this.carName = new CarName(carName);
        this.position = DEFAULT_POSITION;
    }

    public void attempt(MoveStrategy strategy) {
        if (strategy.canMove()) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName(){
        return carName.getName();
    }
}
