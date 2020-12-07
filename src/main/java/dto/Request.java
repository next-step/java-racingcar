package dto;

public class Request {

    private final String carNames;

    private final int round;

    public Request(final String carNames, final int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public String getCarNames() {
        return carNames;
    }
}
