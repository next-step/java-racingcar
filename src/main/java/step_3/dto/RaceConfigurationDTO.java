package step_3.dto;

public class RaceConfigurationDTO {
    private int roundCount;
    private int carCount;

    public RaceConfigurationDTO(int roundCount, int carCount) {
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
