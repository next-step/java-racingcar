package racinggame.dto;

public class RaceInputDTO {
    private int roundCount;
    private int carCount;

    public RaceInputDTO(int roundCount, int carCount) {
        this.roundCount = roundCount;
        this.carCount = carCount;
    }

    public int roundCount() {
        return roundCount;
    }

    public int carCount() {
        return carCount;
    }
}
