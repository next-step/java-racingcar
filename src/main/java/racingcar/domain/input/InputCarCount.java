package racingcar.domain.input;

public class InputCarCount extends PositiveNumber {

    private int carCount;

    public InputCarCount(String value) {
        super(value);
        this.carCount = super.positiveNumber;
    }

    public int getCarCount() {
        return this.carCount;
    }
}
