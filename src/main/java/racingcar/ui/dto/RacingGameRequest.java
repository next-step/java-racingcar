package racingcar.ui.dto;

public class RacingGameRequest {

    private int carNumber;

    public RacingGameRequest(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
