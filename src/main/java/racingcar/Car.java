package racingcar;

public class Car {

    private int position = 0;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void updateByNumber(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
