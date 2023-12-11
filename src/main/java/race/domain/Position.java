package race.domain;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void moveForward() {
        this.position++;
    }

    public int position() {
        return this.position;
    }

    public boolean isSame(int position) {
        return this.position == position;
    }

}
