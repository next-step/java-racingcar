package model;


public class Car {

    private final String name;
    private int currentPosition = 0;

    public static Car carWithName(String name){
        return new Car(name);
    }

    private Car(String name){
        this.name = name;
    }
    public void move() {
        this.currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
