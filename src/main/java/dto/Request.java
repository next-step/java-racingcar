package dto;

public class Request {

    private final int carCount;

    private final int round;

    public Request(final int carCount, final int round) {
        this.carCount = carCount;
        this.round = round;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRound() {
        return round;
    }
}
