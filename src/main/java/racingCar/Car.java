package racingCar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private static final int LIMIT_NAME_LENGH = 5;
    private int distance;
    private String name;

    public Car(String name) {
        checkName(name);
        this.name = name;
        this.distance = 0;
    }
    public Car(String name, int distance) {
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

    public int getDistance() {
        return this.distance;
    }

    public void move(int dis) {
        if (isMoveable(dis)) {
            this.distance++;
        }
    }

    private boolean isMoveable(int dis) {
        return dis >= LIMIT_NUM;
    }

    public int max(int max) {
        return Math.max(max, this.distance);
    }

    public boolean isMax(int max) {
        return this.distance == max;
    }
}
