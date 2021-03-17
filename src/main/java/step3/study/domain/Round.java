package step3.study.domain;

public class Round {
    private int round;

    public Round(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("시행 횟수는 0회 이상이어야 합니다.");
        }
        this.round = round;
    }

    public void next() {
        this.round--;
    }

    public boolean racing() {
        return round > 0;
    }
}
