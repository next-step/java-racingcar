package domain.cars;

public class RacingCar {

    private Name name;
    private Distance distance;

    public RacingCar() {
        this.name = new Name();
        this.distance = new Distance();
    }

    public RacingCar(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public RacingCar(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void moveOrStop(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            distance.move();
        }
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public boolean isSameDistance(int maxDistance) {
        return distance.isSameDistance(maxDistance);
    }

    public String getName() {
        return name.getName();
    }

    public String getResult() {
        return this.name.getName() + " : " + "-".repeat(this.distance.getDistance());
    }
}
