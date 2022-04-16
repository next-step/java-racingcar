package racingcar_step4;

public class InputValue {
    private String carsString;
    private int tryNum;

    public InputValue(String carsString, int tryNum) {
        this.carsString = carsString;
        this.tryNum = tryNum;
    }

    public String[] getCarsArray() {
        return carsString.split(",");
    }

    public int getTryNum() {
        return tryNum;
    }
}
