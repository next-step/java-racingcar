package carRacingWinner.entity;

public class Car {

    String name;
    int location;

    public void move() {
        location++;
    }

    public void name(String name) {
        this.name = name;
    }
}
