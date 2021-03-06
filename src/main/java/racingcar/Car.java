package racingcar;

public class Car {

    private int position = 0;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void updateByCondition(int number) {
        if (isAcceptCondition(number)) {
            position++;
        }
    }

    public boolean isAcceptCondition(int number) {
        if (number > 9 || number < 0) {
            throw new IllegalArgumentException("0 ~ 9까지의 값만 사용할 수 있습니다.");
        }

        return number >= 4;
    }
}
