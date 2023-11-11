package racingcar.ui.dto;

public class RacingGameRequest {

    private final String[] carNames;
    private final int endTurn;

    public RacingGameRequest(String[] carNames, int endTurn) {
        this.carNames = carNames;
        if (endTurn <= 0) {
            throw new IllegalArgumentException("End turn must be more than 0.");
        }

        this.endTurn = endTurn;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getEndTurn() { return endTurn; }
}
