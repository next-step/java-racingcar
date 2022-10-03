package racing;

public class Car {
    private static final int AVAILABLE_RUN_THRESHOLD = 4;

    private int distance = 0;

    public void run() {
        if (canRun()) { distance += 1; }
    }

    public int getDistance() {
        return distance;
    }

    private static boolean canRun() {
        return generateRandom() >= AVAILABLE_RUN_THRESHOLD;
    }

    private static int generateRandom() {
        return (int)(Math.random() * 10) + 1;
    }
}
