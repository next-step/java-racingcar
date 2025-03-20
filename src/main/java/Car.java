public class Car {

    @Deprecated
    public static final String TEMP_CAR_NAME = "temp";
    private static final int MOVEMENT_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    @Deprecated
    public Car() {
        this.name = TEMP_CAR_NAME;
    }

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("Name cannot be longer than 5 characters");
        }
    }

    public void move(int seed) {
        if (seed < 0 || seed > 9) {
            throw new IllegalArgumentException("Invalid seed: " + seed);
        }

        if (seed >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
