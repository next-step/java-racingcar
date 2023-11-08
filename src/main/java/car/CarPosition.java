package car;

public class CarPosition implements Comparable<CarPosition> {

    private int distance;
    private static final int MIN_DISTANCE = 0;

    public CarPosition(int distance) {
        validateMoreThanMinDistance(distance);
        this.distance = distance;
    }

    private void validateMoreThanMinDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("distance는 항상 0 이상이어야 합니다.");
        }
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
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
