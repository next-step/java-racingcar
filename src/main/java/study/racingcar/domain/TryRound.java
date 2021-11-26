package study.racingcar.domain;

import java.util.Objects;

public class TryRound {
    private static final String EXCEPTION_MESSAGE_MIN_TRY_ROUND = "시도 횟수가 1보다 작은 수 입니다.";
    private static final int MIN_INPUT_NUMBER = 1;
    private static final int START_ROUND = 1;

    private final int tryRound;
    private int nowRound;

    public TryRound(int tryRound) {
        this(tryRound, START_ROUND);
    }

    public TryRound(int tryRound, int nowRound) {
        if (MIN_INPUT_NUMBER > tryRound) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_TRY_ROUND);
        }
        this.tryRound = tryRound;
        this.nowRound = nowRound;
    }

    public void nextRound(){
        nowRound++;
    }

    public boolean moreRound() {
        return tryRound >= nowRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryRound tryRound1 = (TryRound) o;
        return tryRound == tryRound1.tryRound && nowRound == tryRound1.nowRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryRound, nowRound);
    }
}
