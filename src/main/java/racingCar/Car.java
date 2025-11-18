package racingCar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private static final int LIMIT_NAME_LENGH = 5;
    private Distance distance;
    private String name;

    public Car(String name) {
        this(name,new Distance());
    }
    public Car(String name, Distance distance) {
        checkName(name);
        this.name =  name;
        this.distance = distance;
    }
    private void checkName(String name) {
        if (name.length() > LIMIT_NAME_LENGH) {
            throw new RuntimeException("이름이 5글자 초과되면 안됩니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void move(int dis) {
        if (isMoveable(dis)) {
            this.distance.plus();
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
