package nextstep.javaracingcar;

public class Round {
    private int remain;

    public Round(final int count) {
        if (count < 0) {
            throw new RuntimeException("음수 값은 처리할 수 없습니다.");
        }
        this.remain = count;
    }
    public boolean hasNextRound() {
        return remain > 0;
    }

    public void run() {
        if(this.remain == 0) {
            throw new IllegalStateException("더 이상 진행할 수 없습니다.");
        }
        remain--;
    }
}
