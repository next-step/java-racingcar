package step4.domain;

public class Round {
    private int round;

    public Round(int inputRound) {
        this.round = inputRound;
    }

    public static Round from(int inputRound) {
        return new Round(inputRound);
    }

    public int getRound() {
        return round;
    }
}
