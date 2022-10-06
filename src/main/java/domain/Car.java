package domain;

public class Car {

    private int distance;

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance = this.distance + 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.getDistance(); i++) {
            result.append("-");
        }
        return result.toString();
    }
}
