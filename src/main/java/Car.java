public class Car {

    private int distance;

    public void go(int forwardCondition) {
        if (forwardCondition >= 4) {
            this.distance++;
        }
    }

    public int distance() {
        return this.distance;
    }
}
