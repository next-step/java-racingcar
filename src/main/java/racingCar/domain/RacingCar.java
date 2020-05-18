package racingCar.domain;

public class RacingCar {
    private int position;

    public int getPosition() {
        return position;
    }

    public void move(boolean isMove) {
        if(isMove) {
            position++;
        }
    }
}
