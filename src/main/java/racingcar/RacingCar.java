package racingcar;

public class RacingCar {

    private int coord;

    public int go() {
        return ++this.coord;
    }

    public int stop() {
        return this.coord;
    }

    public int checkRandom() {
        int randomValue = (int) (Math.random() * 10) + 1;
        if (randomValue >= 4)
            return go();
        return stop();
    }
}
