package carRacingWinner.entity;

import java.util.Random;

public class Car {

    private String name;
    private static final String CAR_LOCATION_DISPLAY = "-";
    int location;

    public Car(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("차량의 이름이 너무 깁니다.");
        this.name = name;
    }



    public void move(int randomValue) {
        if (randomValue > 4)
            location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void print() {
        System.out.print(name + " : ");
        for (int i = 0; i <= location; i++) {
            System.out.print(CAR_LOCATION_DISPLAY);
        }
        System.out.println();
    }
}
