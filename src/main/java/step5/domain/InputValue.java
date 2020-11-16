package step5.domain;

/**
 * Created By mand2 on 2020-11-12.
 */
public class InputValue {
    private final String carNames;
    private final int rounds;

    public InputValue(String carNames, int rounds) {
        this.carNames = carNames;
        this.rounds = rounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRounds() {
        return rounds;
    }
}
