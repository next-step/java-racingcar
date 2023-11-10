package racingcar.ui.dto;

public class RacingGameRequest {

    private final String inputCars;
    private final int endTurn;

    public RacingGameRequest(String inputCars, int endTurn) {
        this.inputCars = inputCars;
        if (endTurn <= 0) {
            throw new IllegalArgumentException("End turn must be more than 0.");
        }

        this.endTurn = endTurn;
    }

    public String getInputCars() {
        return inputCars;
    }

    public int getEndTurn() { return endTurn; }
}
