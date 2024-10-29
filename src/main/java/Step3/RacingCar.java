package Step3;

public class RacingCar {
    private final int THRESHOLD = 4;
    private final int MOVE_DISTANCE = 1;

    private String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public int move(int rand) {
        if (rand < THRESHOLD) {
            return this.position;
        }

        this.position += MOVE_DISTANCE;

        return this.position;
    }
}
