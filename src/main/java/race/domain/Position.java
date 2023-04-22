package race.domain;

public class Position {

    private int movingDistance;

    public Position(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void increase() {
        this.movingDistance++;
    }

    public int getDistance() {
        return this.movingDistance;
    }

    public boolean isSame(int maxDistance) {
        return this.movingDistance == maxDistance;
    }
}
