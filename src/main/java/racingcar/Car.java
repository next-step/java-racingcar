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
        return number >= 4;
    }
}
