package stage4;

public class InputValue {
    private final int carNum;
    private final int tryNum;

    public InputValue(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}
