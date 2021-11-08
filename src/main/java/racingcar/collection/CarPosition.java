package racingcar.collection;

/**
 * Created by owen.ny on 2021/11/08.
 */
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
