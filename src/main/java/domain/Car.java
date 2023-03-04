package domain;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (isMove())
            moveForward();
    }

    private void moveForward() {
        distance++;
    }

    private boolean isMove() {
        if (getRandomNumber() >= 4)
            return true;

        return false;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
