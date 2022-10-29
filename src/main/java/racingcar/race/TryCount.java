package racingcar.race;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        if (tryCount < 0) {
            throw new RuntimeException("0보다 큰 수를 입력하세요");
        }
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
