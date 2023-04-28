package racingcar;

import java.util.Random;

public class SimpleCar {
    public static int RANDOM_BOUND = 10;
    public static int LEAST_MOVABLE_NUM = 4;
    public static int MAX_NAME_LENGTH = 5;

    private int position = 0;
    private String name;

    public SimpleCar(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid Car Name");
        }
        this.name = name;
    }

    private SimpleCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void run() {
        Random random = new Random();
        if (random.nextInt(RANDOM_BOUND) >= LEAST_MOVABLE_NUM) {
            position += 1;
        }
    }

    public SimpleCar copy() {
        return new SimpleCar(this.name, this.getPosition());
    }

    public Integer getPosition() {
        return position;
    }

    public String getCarName() {
        return name;
    }

    static boolean isValidName(String name) {
        return name != null && !name.isBlank() && name.length() <= MAX_NAME_LENGTH;
    }
}
