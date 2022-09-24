package racing;

public class Car {
    private int distance = 0;
    private static final int AVAILABLE_RUN_THRESHOLD = 4;
    public void run() {
        if (canRun()) { distance += 1; }
    }

    public void printDistance() {
        ResultView.printDistance(distance());
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
