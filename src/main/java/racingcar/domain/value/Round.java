package racingcar.domain.value;

public class Round {

    private static int round;
    private static final String MAX_ROUND_ERROR = "시도 횟수는 10이하로 입력해주세요";

    private Round(int round) {

        if(round > 10) {
            throw new IllegalArgumentException(MAX_ROUND_ERROR);
        }
        this.round = round;
    }

    public static Round from(int tryCount) {
        return new Round(tryCount);
    }

    public int getRound() {
        return this.round;
    }

    public int minus() {
        return round--;
    }
}
