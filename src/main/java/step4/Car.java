package step4;


public class Car {
    private String name;
    private int currentPosition;

    Car(String name) {
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
