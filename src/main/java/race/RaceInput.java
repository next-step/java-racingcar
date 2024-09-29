package race;

public class RaceInput {
    private final String carCount;
    private final String randomStopOrGoCount;

    public RaceInput(String carCount, String randomStopOrGoCount) {
        this.carCount = carCount;
        this.randomStopOrGoCount = randomStopOrGoCount;
    }

    public String carCount() {
        return this.carCount;
    }

    public String randomStopOrGoCount() {
        return this.randomStopOrGoCount;
    }
}
