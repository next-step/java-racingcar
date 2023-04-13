package racingcar;

public class RacingCar {
    private int distance;
    private static int START = 0;
    private static int GO = 1;
    private static int GO_STANDARD = 4;

    public RacingCar() {
        this.distance = START;
    }

    public int drive(int randomNumber)
    {
        if (randomNumber >= GO_STANDARD) {
            distance += GO;
        }
        return distance;
    }

    public int getDistance()
    {
        return distance;
    }

}
