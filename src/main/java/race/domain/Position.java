package race.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

}
