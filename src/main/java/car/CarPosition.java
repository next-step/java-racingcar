package car;

public class CarPosition implements Comparable<CarPosition> {

    private int distance;

    public CarPosition(int distance) {
        isMoreThanZero(distance);
        this.distance = distance;
    }

    private void isMoreThanZero(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("distance는 항상 0 이상이어야 합니다.");
        }
    }

    public int getDistance() {
        return distance;
    }

    public void incrementDistance() {
        distance++;
    }

    @Override
    public int compareTo(CarPosition otherCarPosition) {
        return this.distance - otherCarPosition.distance;
    }

    public boolean isSameDistance(CarPosition winnerCarPosition) {
        return this.distance == winnerCarPosition.distance;
    }
}
