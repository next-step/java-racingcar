package study.step4.dto;

public class RacingInput {

    private final String[] carNames;
    private final int tryNum;

    public RacingInput(String[] carNames, int tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }
}
