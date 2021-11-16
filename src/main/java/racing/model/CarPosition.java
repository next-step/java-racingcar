package racing.model;

/**
 * .
 */
public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void forward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
