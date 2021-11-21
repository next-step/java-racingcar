package racingcar.domain;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void increasePosition() {
        this.position++;
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
