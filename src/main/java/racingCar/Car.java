package racingCar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private static final int LIMIT_NAME_LENGH = 5;
    private Distance distance;
    private Name name;

    public Car(String name) {
        this(new Name(name), new Distance());
    }
    public Car(Name name, Distance distance) {
        this.name =  name;
        this.distance = distance;
    }

    public String getName() {
        return this.name.value();
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void move(int dis) {
        if (isMoveable(dis)) {
            this.distance = this.distance.plus();
        }
    }

    public Distance max(Distance max) {
        return this.distance.greaterThan(max);
    }

    private boolean isMoveable(int dis) {
        return dis >= LIMIT_NUM;
    }

    public boolean isMax(Distance max) {
        return this.distance.equals(max);
    }
}
