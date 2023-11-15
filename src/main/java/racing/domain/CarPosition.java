package racing.domain;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        position++;
    }
}
