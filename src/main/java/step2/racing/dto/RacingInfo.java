package step2.racing.dto;

public class RacingInfo {

    private int carCount;
    private int attempts;

    public RacingInfo(int carCount, int attempts) {

        this.carCount = carCount;
        this.attempts = attempts;
    }

    public int getCarCount() {

        return carCount;
    }

    public int getAttempts() {

        return attempts;
    }
}
