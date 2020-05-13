package racing.dto;

public class RacingCreateDto {
    private int totalRacingCount;
    private int carCount;

    public RacingCreateDto(int totalRacingCount, int carCount) {
        this.totalRacingCount = totalRacingCount;
        this.carCount = carCount;
    }

    public int totalRacingCount() {
        return this.totalRacingCount;
    }

    public int carCount() {
        return this.carCount;
    }
}
