package racingcar;

public class RacingCar {

    private int distance;

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }
}
