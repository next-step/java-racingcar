package racingcar.vo.car;

public class Location {
    private int position;

    public void forward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
