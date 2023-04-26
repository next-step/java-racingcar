package racingcar.domain;

public class PlayCount {

    private final int count;

    public PlayCount(int count) {
        this.count = count;
        validateEmptyCount();
        validateNegativeCount();
    }

    private void validateEmptyCount() {
        if (this.count == 0) {
            throw new IllegalArgumentException("게임 횟수는 0일 수 없습니다.");
        }
    }

    private void validateNegativeCount() {
        if (this.count < 0) {
            throw new IllegalArgumentException("게임 횟수는 음수일 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
