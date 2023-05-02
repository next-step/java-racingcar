package racing.dto;

public class RaceRequestDto {
    private String[] carNames;
    private int attempts;

    public RaceRequestDto(String[] carNames, int attempts) {
        this.carNames = carNames;
        this.attempts = attempts;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getAttempts() {
        return attempts;
    }
}
