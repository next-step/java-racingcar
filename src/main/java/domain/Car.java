package domain;

import static domain.CarConstant.*;

public class Car {
    private final String carName;
    private int position = INIT_POSITION;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 5자 초과입니다");
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOrNot() {
        if (isMove()) {
            this.position++;
        }
    }

    private boolean isMove() {
        return Math.random() * 10 >= FORWARD_NUM;
    }
}
