package racingcar;

public class Car {
    private final String carName;
    private int position;
    private String moveRegex;
    private static final int FORWARD_NUM = 4;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;

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
        if (number >= FORWARD_NUM) {
            this.position++;
        }
    }

    public String getMoveRegex() {
        moveRegex = "";

        for (int i = 0; i < this.getPosition(); i++) {
            this.moveRegex += "-";
        }

        return moveRegex;
    }


}
