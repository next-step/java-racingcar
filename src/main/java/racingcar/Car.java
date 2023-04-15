package racingcar;

public class Car {

    private int position = 0;

    public void move(int distance) {
        if (judgeForth(distance)) position++;
    }

    public boolean judgeForth(int degree) {
        if (degree >= 4 && degree <= 9) {
            return true;
        }
        return false;
    }

    public int nowPosition() {
        return position;
    }

}
