package domain;

/**
 * 자동차 게임에 들어가는 옵션
 */
public class Option {
    private final int round;
    private final CustomizedRandom random;

    public Option(int round, int minBound, int maxBound) {
        this.round = round;
        this.random = new CustomizedRandom(minBound, maxBound);
    }

    public int getRound() {
        return round;
    }

    public boolean getRandomResult() {
        return random.getResult();
    }
}
