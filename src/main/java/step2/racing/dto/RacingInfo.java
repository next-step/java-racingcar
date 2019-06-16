package step2.racing.dto;

public class RacingInfo {

    private int carCount;
    private int attempts;

    private RacingInfo() {}

    public static RacingInfo of(int carCount, int attempts) {
        RacingInfo racingInfo = new RacingInfo();
        racingInfo.carCount = carCount;
        racingInfo.attempts = attempts;
        return racingInfo;
    }

    public int getCarCount() {

        return carCount;
    }

    public int getAttempts() {

        return attempts;
    }
}
