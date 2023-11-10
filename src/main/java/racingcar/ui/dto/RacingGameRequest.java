package racingcar.ui.dto;

public class RacingGameRequest {

    private final int carNumber;
    private final int endTurn;

    public RacingGameRequest(int carNumber, int endTurn) {
        this.carNumber = carNumber;
        this.endTurn = endTurn;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getEndTurn() { return endTurn; }
}
