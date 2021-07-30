package racingcargame;

public class RacingCar {
    private static final int MOVING_VALUE = 4;
    private ResultView resultView = new ResultView();

    public String tryToMoveCar(int randomValue) {
        if(randomValue >= MOVING_VALUE) {
            return this.move();
        }
        return this.stop();
    }

    public String move() {
        return resultView.move();
    }

    public String stop() {
        return resultView.stop();
    }
}
