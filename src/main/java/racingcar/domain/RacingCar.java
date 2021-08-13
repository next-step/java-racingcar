package racingcar.domain;

public class RacingCar {
    private final static int RANDOM_NUMBER = 4;

    private int position;

    public RacingCar() {
    }

    public void move(int randomNumber) {
        if (randomNumber >= RANDOM_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
