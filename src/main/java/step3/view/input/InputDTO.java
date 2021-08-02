package step3.view.input;

public class InputDTO {

    private int carCount;
    private int tryCount;

    public InputDTO(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
