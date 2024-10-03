package racingcar;

public class Car {

    private int position = 0;

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }


}
