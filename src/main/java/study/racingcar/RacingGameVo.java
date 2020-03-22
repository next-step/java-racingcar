package study.racingcar;

public class RacingGameVo {
    private static final int MIN = 0;
    private int numberOfCar;
    private int time;

    public RacingGameVo(int numberOfCar, int time) {
        if ((numberOfCar < MIN) || (time < MIN)) {
            throw new IllegalArgumentException(
                    String.format("차 댓수와 시도 횟수는 %d 이상이여야 합니다.", MIN));
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
