package study.racing.domain;

public class Car {
    public int currentLocation;
    public String name;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public boolean canMove(int randomValue) {
        return randomValue >= 4;
    }


    public Car(int currentLocation, String name) {
        if (name.length() > 5) {
            throw new RuntimeException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.currentLocation = currentLocation;
        this.name = name;

    }

    public void moveForward() {
        this.currentLocation += 1;
    }
}
