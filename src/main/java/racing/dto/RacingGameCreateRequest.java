package racing.dto;

public class RacingGameCreateRequest {
    private int carNumber;
    private int time;

    public RacingGameCreateRequest(int carNumber, int time) {
        this.carNumber = carNumber;
        this.time = time;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTime() {
        return time;
    }
}
