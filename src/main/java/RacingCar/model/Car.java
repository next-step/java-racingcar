package RacingCar.model;

public class Car {
    private int id;
    private int move;

    public Car(int id) {
        this.id = id;
        this.move = 0;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
