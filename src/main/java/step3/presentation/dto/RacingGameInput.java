package step3.presentation.dto;

public class RacingGameInput {

    private int carCnt;
    private int round;

    public RacingGameInput(int carCnt, int round) {
        this.carCnt = carCnt;
        this.round = round;
    }

    public int getCarCnt() {
        return carCnt;
    }

    public int getRound() {
        return round;
    }
}
