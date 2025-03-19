public class Car {

    private static final int MOVEMENT_THRESHOLD = 4;
    private int position = 0;

    public void move(int seed) {
        if (seed < 0 || seed > 9) {
            throw new IllegalArgumentException("Invalid seed: " + seed);
        }

        if (seed >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
