package carracing.domain;

public class Car {
    public static final int CAR_MOVING_BOUND = 4;

    private Name name;
    private Distance distance = new Distance(1);

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int randomNum) {
        if (randomNum >= CAR_MOVING_BOUND) {
            distance = distance.add(1);
        }
    }

    public String makeDistanceString() {
        return name.getValue() + " : " + distance.makeString();
    }

    public String getName() {
        return name.getValue();
    }

    public boolean hasSameDistance(int maxDistance) {
        return distance.hasSameValue(maxDistance);
    }

    public int returnMaxDistance(int maxDistance) {
        return distance.returnMaxValue(maxDistance);
    }
}
