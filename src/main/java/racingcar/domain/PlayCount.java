package racingcar.domain;

public class PlayCount {

    private final int count;

    public PlayCount(int count) {
        this.count = count;
        validateEmptyCount();
    }

    public int getCount() {
        return count;
    }

    private void validateEmptyCount() {
        if (this.count <= 0) {
            throw new IllegalArgumentException("게임 횟수는 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayCount)) return false;

        PlayCount playCount = (PlayCount) o;
        return count == playCount.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
