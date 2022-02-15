package racing.dto;

public class RacingInfo {

    private final String carNames;
    private final int totalRoundNumber;

    public RacingInfo(String carNames, int totalRoundNumber) {
        this.carNames = carNames;
        this.totalRoundNumber = totalRoundNumber;
    }

    public int getTotalRoundNumber() {
        return totalRoundNumber;
    }

    public String getCarNames() {
        return carNames;
    }

}
