package racingcar;

public class Car {

    private int position = 0;

    public int move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void forceMove() {
        position++;
    }
}
