package racingcar.model;

public class Car {
    private final String name;
    private final MovingDistance movingDistance;

    public Car(String name) {
        this(name,0);
    }

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = new MovingDistance(movingDistance);
    }

    public void move() {
         movingDistance.increase(RandomNumber.make());
    }

    public int isLongest(int longestMovingDistance) {
        return movingDistance.isLongest(longestMovingDistance);
    }

    public boolean isSame(int longestMovingDistance) {
        return movingDistance.isSame(longestMovingDistance);
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance.getValue();
    }
}
