package step3.domain;

public class RaceCondition {
    public int carCount;
    public int raceRound;

    private RaceCondition(int carCount, int raceRound) {
        this.carCount = carCount;
        this.raceRound = raceRound;
    }

    public static RaceCondition create(int carCount, int raceRound) {
        if (carCount < 0 || raceRound < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        return new RaceCondition(carCount, raceRound);
    }
}
