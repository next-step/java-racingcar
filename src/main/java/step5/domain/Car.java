package step5.domain;


public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public void move(int distance) {
        currentPosition += distance;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName(){
        return name;
    }

}
