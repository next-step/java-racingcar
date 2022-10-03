package racinggame.dto;

public class RaceInputDTO {
    private final int roundCount;
    private final String[] carNames;

    public RaceInputDTO(int roundCount, String[] carNames) {
        this.roundCount = roundCount;
        this.carNames = carNames;
    }

    public int roundCount() {
        return roundCount;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
