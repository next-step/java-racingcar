package racingcar.collection;

public class Winner {
    private final CarName winner;

    public Winner(CarName winner) {
        this.winner = winner;
    }

    public String getName() {
        return winner.toString();
    }
}
