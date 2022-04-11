package carracing;

public class RacingCar {
    private int position;

    public RacingCar() {}

    public RacingCar(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += 1;
    }
}
