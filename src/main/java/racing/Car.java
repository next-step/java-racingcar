package racing;

public class Car {
    private static int distance = 0;
    private static final int AVAILABLE_RUN_THRESHOLD = 4;
    public void run() {
        if (canRun()) { distance += 1; }
    }

    public int distance() {
        return distance;
    }

    private static boolean canRun() {
        return generateRandom() >= AVAILABLE_RUN_THRESHOLD;
    }

    private static int generateRandom() {
        return (int)(Math.random() * 10) + 1;
    }
}
