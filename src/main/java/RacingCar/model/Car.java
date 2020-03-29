package RacingCar.model;

public class Car {

    private int move;
    private String name;


    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

}