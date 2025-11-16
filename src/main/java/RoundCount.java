public class RoundCount {
    private final int count;

    RoundCount(int count) {
        if (!isValidCount(count)) {
            throw new IllegalArgumentException("진행 횟수는 1 이상이어야 합니다.");
        }
        this.count = count;
    }

    int count() {
        return this.count;
    }

    private boolean isValidCount(int count) {
        return count > 0;
    }
}
