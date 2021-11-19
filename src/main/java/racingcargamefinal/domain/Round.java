package racingcargamefinal.domain;

public class Round {

    public static final int MIN_ROUND_COUNT = 0;

    private final int roundCount;

    public Round(int tryCount) {
        validate(tryCount);
        this.roundCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("라운드는 0 미만일 수 없습니다.");
        }
    }

    public Round play() {
        if (isEnd()) {
            throw new IllegalStateException("모든 라운드가 끝났습니다.");
        }
        return new Round(roundCount - 1);
    }

    public boolean isEnd() {
        return roundCount <= MIN_ROUND_COUNT;
    }

}
