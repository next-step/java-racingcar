package racing.domain;

public class Racing {

    private boolean[] racingResult;

    public Racing(boolean[] racingResult) {
        this.racingResult = racingResult;
    }
    public int getRacingLength() {
        return racingResult.length;
    }

    public boolean getRacingDetailResult(int car) {
        return racingResult[car];
    }

}
