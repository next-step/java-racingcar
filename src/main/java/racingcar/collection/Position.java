package racingcar.collection;

public class Position {
    private Integer position;

    public Position() {
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public void increasePosition() {
        position++;
    }

    public boolean equalsTo(int position) {
        return this.position == position;
    }
}
