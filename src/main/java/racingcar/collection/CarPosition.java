package racingcar.collection;

public class CarPosition {
    private Integer position;

    public CarPosition() {
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public void increasePosition() {
        position++;
    }
}
