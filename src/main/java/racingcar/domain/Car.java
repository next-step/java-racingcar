package racingcar;

public class Car {

    private String carName;
    private int position = 0;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }
    public int getPosition() {
        return position;
    }

    public void updateByCondition(int number) {
        isValidate(number);

        if (Conditions.isAcceptCondition(number)) {
            position++;
        }
    }

    public void isValidate(int number) {
        if (Conditions.isInvalidate(number)) {
            throw new IllegalArgumentException("0 ~ 9까지의 값만 사용할 수 있습니다.");
        }
    }
}
