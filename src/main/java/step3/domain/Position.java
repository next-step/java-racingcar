package step3.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void forward() {
        this.position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int position() {
        return this.position;
    }

}
