package racingcargame;

public class Distance {
    private int value = 0;

    public Distance(int value) {
        this.value = value;
    }

    public Distance(RacingCar racingCar) {
        value = racingCar.showDistance();
    }

    public int increase() {
        return value += 1;
    }

    public int getValue() {
        return value;
    }

    public int showWinnerDistance(RacingCar racingCar) {
        return racingCar.showDistance();
    }
}
