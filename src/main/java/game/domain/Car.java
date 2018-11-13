package game.domain;

public class Car implements Comparable<Car> {
    private static final int MOVE_FLAG = 4;
    private int location;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void increaseLocation() {
        this.location++;
    }

    public void move(int randomValue) {
        if (isMove(randomValue)) {
            this.increaseLocation();
        }
    }

    private boolean isMove(int randomValue) {
        return MOVE_FLAG <= randomValue;
    }

    public boolean isEqualsMaxScore(int location) {
        return this.location == location;
    }

    @Override
    public int compareTo(Car target) {
        return this.location - target.location;
    }
}
