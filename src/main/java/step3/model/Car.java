package step3.model;

import step3.App;

public class Car {
    private String distance = "";

    public void moveIf(int num) {
        if (num > App.RANGE || num < App.CRITERION_NUMBER) return;
        move();
    }

    public void move() {
        this.distance += "-";
    }

    public void show() {
        System.out.println(distance);
    }

    public int now() {
        return distance.length();
    }
}
