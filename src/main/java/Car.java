public class Car {

    private int distance;

    public void go(boolean condition) {
        if (condition) {
            this.distance++;
        }
    }

    public int distance() {
        return this.distance;
    }
}
