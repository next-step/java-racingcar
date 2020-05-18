package racingCar.domain;

public class RacingCar implements Car {
    private static final int MOVABLE_MIN = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    @Override
    public void move(int randomNumber) {
        if(randomNumber >= MOVABLE_MIN) {
            position++;
        }
    }
}
