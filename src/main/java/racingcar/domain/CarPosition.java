package racingcar.domain;

public final class CarPosition {
    private final int position;
    private static final int STEP = 1;

    public CarPosition(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public CarPosition increasePosition() {
        return new CarPosition(this.position + STEP);
    }

    public boolean isEqaul(int position) {
        return this.position == position;
    }

    public int maxPosition(int maxPositioin) {
        if (this.position > maxPositioin) {
            return this.position;
        }
        return maxPositioin;
    }
}
