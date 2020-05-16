package racing.dto;

public class RaceInformation {
    private int totalRacingCount;
    private String[] carNames;

    public RaceInformation(int totalRacingCount, String[] carNames) {
        this.totalRacingCount = totalRacingCount;
        this.carNames = carNames;
    }

    public int getTotalRacingCount() {
        return this.totalRacingCount;
    }

    public String[] getCarNames() {
        return this.carNames;
    }
}
