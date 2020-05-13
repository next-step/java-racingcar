package racing.dto;

public class RacingCreateValueObject {
    private int totalRacingCount;
    private String[] carNames;

    public RacingCreateValueObject(int totalRacingCount, String[] carNames) {
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
