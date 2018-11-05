package racingGame.model;

public class RacingCar {
    private int position = 0;

    public int getPosition() {
        return this.position;
    }

    public void setForward() {
        this.position += 1;
    }
}
