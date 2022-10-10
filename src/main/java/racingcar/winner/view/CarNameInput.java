package racingcar.winner.view;

public class CarNameInput {
    private static final String DELIMITER = ",";
    private final String input;

    public CarNameInput(final String input) {
        this.input = input;
    }

    public String[] parse() {
        return input.split(DELIMITER);
    }
}
