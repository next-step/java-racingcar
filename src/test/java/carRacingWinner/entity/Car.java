package carRacingWinner.entity;

public class Car {

    String name;
    int location;

    public Car(String word) {
        this.name = word;
    }

    public void move() {
        location++;
    }
}
