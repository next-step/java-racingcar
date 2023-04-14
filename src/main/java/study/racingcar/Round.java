package study.racingcar;

import study.racingcar.utils.NumberUtils;

public class Round {

    private final int count;

    public Round(int count) {
        validateTotalRoundCount(count);
        this.count = count;
    }

    private void validateTotalRoundCount(int count) {
        if (NumberUtils.isNotPositive(count)) {
            throw new IllegalArgumentException("0 이상의 값을 입력해 주세요");
        }
    }

    public int getTotalRounds() {
        return count;
    }
}
