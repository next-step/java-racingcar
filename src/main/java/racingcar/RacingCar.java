package racingcar;

import java.util.List;

public class RacingCar {
    private String carName;
    private int position;
    private int MOVE_NUMBER = 4;

    public RacingCar(String carName) {
        nameCheck(carName);

        this.carName = carName;
        this.position = 0;
    }

    private void nameCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }

    public void moveOrNot(int number) {
        if (number >= MOVE_NUMBER) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() { return carName; }
}
