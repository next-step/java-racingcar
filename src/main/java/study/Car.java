package study;

import java.util.Random;

public class Car {
    public static final String EMPTY_NAME = "";
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

    public Car(int currentLocation) {
        this.currentLocation = currentLocation;
        this.name = EMPTY_NAME;
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

    public String displayCurrentStatus() {
        String status = "";
        status += getName() + " : ";
        for (int i=0;i<getCurrentLocation();i++){
            status += "-";
        }
        status += "\n";
        return status;
    }
}
