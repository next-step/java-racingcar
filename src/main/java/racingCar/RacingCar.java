package racingCar;

public class RacingCar {

    private int position = 0;


    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}