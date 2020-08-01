package step3.domain;

public class Input {
    private final int carNo;
    private final int totalLaps;

    private Input(int carNo, int totalLaps) {
        this.carNo = carNo;
        this.totalLaps = totalLaps;
    }

    public static Input of(int carNo, int totalLaps) {
        return new Input(carNo, totalLaps);
    }

    public int getCarNo() {
        return carNo;
    }

    public int getTotalLaps() {
        return totalLaps;
    }

}
