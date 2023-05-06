package study.racingcar;

public class RacingCar {

    public int forwardCount;

    public void forward() {
        this.forwardCount++;
    }

    public void forwardAndStop(int number) {
        if (number >= 4) {
            forward();
        }
    }

}
