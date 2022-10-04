package racing_car_with_winner;

public class CarNameInput {
    private static final String DELIMITER = ",";
    private String input;

    public CarNameInput(String input) {
        this.input = input;
    }

    public String[] parse() {
        return input.split(DELIMITER);
    }
}
