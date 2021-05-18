package racingcar;

import static racingcar.CarConstant.*;

public class Car {
    private final String carName;
    private String moveString;
    private int position = INIT_POSITION;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        validateMoveNumber(number);
        if (number >= FORWARD_NUM) {
            this.position++;
        }
    }

    private void validateMoveNumber(int number){
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("0 ~ 9사이의 숫자가 아닙니다.");
        }
    }


    public String getMoveString() {
        moveString = "";

        for (int i = 0; i < this.getPosition(); i++) {
            this.moveString += MOVE_REGEX_HYPHEN;
        }

        return moveString;
    }
}
