package step3.domain;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        if (checkIfDistanceIsPositiveOrZero(distance)) {
            this.distance = distance;
        }
    }

    private boolean checkIfDistanceIsPositiveOrZero(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Negative number is not allowed for distance");
        }
        return Boolean.TRUE;
    }

    public void moveForward() {
       distance++;
    }

    public int getDistance() {
        return distance;
    }

}
