package racing.model;

public class Position {

    private int position = 0;

    public int getPosition() {
        return this.position;
    }

    public void progress() {
        this.position++;
    }
}
