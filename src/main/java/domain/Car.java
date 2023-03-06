package domain;

public class Car {
    String name;
    int distance;
    final int RANDOM_POVOT_NUMBER = 4;

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
        if (isMove(getRandomNumber()))
            moveForward();
    }

    public void moveForward() {
        distance++;
    }

    public boolean isMove(int randomNumber) {
        if (randomNumber >= RANDOM_POVOT_NUMBER)
            return true;

        return false;
    }

    public int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
