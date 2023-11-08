package racingcar.ui.dto;

public class RacingGameRequest {

    private int carNumber;
    private int endTurn;

    public RacingGameRequest(int carNumber, int endTurn) {
        this.carNumber = carNumber;
        this.endTurn = endTurn;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getEndTurn() { return endTurn; }
}
