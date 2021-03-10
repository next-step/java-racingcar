package racingcar.domain.request;

public class Round {

    private final int MINIMUM = 0;
    private int round;

    public static Round getInstance(String round) {
        return getInstance(toInt(round));
    }

    public static Round getInstance(int round) {
        return new Round(round);
    }

    private Round(int round) {
        if (round <= MINIMUM) throw new IllegalArgumentException("0이하의 숫자로는 레이싱을 진행할 수 없습니다.");
        this.round = round;
    }

    private static int toInt(String round) {
        return Integer.parseInt(round);
    }

    public int getRound() {
        return 0;
    }

}
