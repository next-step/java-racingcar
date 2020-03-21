package study.racingcar;

public class RacingGameData {
    private int numberOfCar;
    private int time;

    public RacingGameData(int numberOfCar, int time) {
        if ((numberOfCar < 0) || (time < 0)) {
            throw new IllegalArgumentException("차 댓수와 시도 횟수는 0 이상이여야 합니다.");
        }
        this.numberOfCar = numberOfCar;
        this.time = time;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getTime() {
        return time;
    }
}
