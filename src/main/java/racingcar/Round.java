package racingcar;

public class Round {

    private final int round;

    public Round(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("라운드 수는 자연수만 가능합니다");
        }
        this.round = round;
    }

    public int value() {
        return round;
    }
}
