package racingcar.domain;

public class Round {

    private int round;

    public Round() {
        this.round = 1;
    }

    public Round(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void update() {
        round++;
    }
}
