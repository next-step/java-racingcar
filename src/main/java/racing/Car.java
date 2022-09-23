package racing;

public class Car {
    private static int distance = 0;
    public void run() {
        distance += 1;
    }
    public int distance() {
        return distance;
    }
}
