package racingcar;

public class Car {
    private final String carName;
    private String moveString;
    private int position = CarConstant.INIT_POSITION;

    public Car(String carName) {
        this.carName = carName;

        if (carName.length() > CarConstant.MAX_NAME_LENGTH) {
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
        if (number >= CarConstant.FORWARD_NUM) {
            this.position++;
        }
    }

    public String getMoveString() {
        moveString = "";

        for (int i = 0; i < this.getPosition(); i++) {
            this.moveString += CarConstant.MOVE_REGEX_HYPHEN;
        }

        return moveString;
    }


}
