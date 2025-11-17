package racing.model;

public class Round {
    private int count;

    public Round(int count) {
        if (!isValidCount(count)) {
            throw new IllegalArgumentException("진행 횟수는 1 이상이어야 합니다.");
        }
        this.count = count;
    }

    public boolean isPlaying() {
        return this.count > 0;
    }

    public void decreaseRemainingCount() {
        if (this.count <= 0) {
            throw new IllegalStateException("더 이상 진행할 라운드가 없습니다.");
        }
        this.count --;
    }

    private boolean isValidCount(int count) {
        return count > 0;
    }
}
