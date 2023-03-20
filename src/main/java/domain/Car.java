package domain;

public class Car {
    String name;
    int distance;
    final int RANDOM_PIVOT_NUMBER = 4;

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
        if (isMove(CarRandom.getRandomNumber()))
            moveForward();
    }

    public void moveForward() {
        distance++;
    }

    public boolean isMove(int randomNumber) {
        if (randomNumber >= RANDOM_PIVOT_NUMBER)
            return true;

        return false;
    }
}
