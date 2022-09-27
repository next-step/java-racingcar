package racingcar;

public class RacingCar {

    public int randomNumber() {
        return (int) Math.random();
    }

    public boolean goStop(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
