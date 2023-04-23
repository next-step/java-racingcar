package domain;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }
    public Distance(int distance) {
       this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance++;
    }

    public boolean isSameDistance(int distance) {
        return distance == this.distance;
    }
}
