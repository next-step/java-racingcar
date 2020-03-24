package RacingCar.model;

public class Car {
    private static final int INIT = 0;

    private int id;
    private int move;

    public Car(int id) {
        this.id = id;
        this.move = INIT;
    }

    public int getId() {
        return id;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
