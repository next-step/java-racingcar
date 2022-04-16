package domain;

public class Position {
    private int position = 0;

    public void goForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
