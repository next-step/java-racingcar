package racing_car_with_winner.model;

public class CarNameInput {
    private static final String DELIMITER = ",";
    private String input;

    public CarNameInput(final String input) {
        this.input = input;
    }

    public String[] parse() {
        return input.split(DELIMITER);
    }
}
