package race;

public class RaceInput {
    private final int carCount;
    private final int gameCount;

    public RaceInput(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public int carCount() {
        return this.carCount;
    }

    public int gameCount() {
        return this.gameCount;
    }
}
