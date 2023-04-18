package step4;

public class Car {
    private static final int RANDOM_LIMIT = 4;

    private String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void move(int random) {
        if (moveAvailable(random)) {
            progress++;
        }
    }

    public static boolean moveAvailable(int random) {
        return random >= RANDOM_LIMIT;
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

}
