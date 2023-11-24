package motorRace;


public class RacingCar {
    private static final int MOVE_CONSTANT = 4;
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONSTANT) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
