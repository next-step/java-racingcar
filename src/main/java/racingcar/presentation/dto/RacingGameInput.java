package racingcar.presentation.dto;

public class RacingGameInput {

    private int carCount;
    private int round;

    public RacingGameInput(int carCount, int round) {
        this.carCount = carCount;
        this.round = round;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRound() {
        return round;
    }
}
