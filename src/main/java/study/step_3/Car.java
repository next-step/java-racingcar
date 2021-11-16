package study.step_3;

public class Car {

    private final int condition = 4;
    private int numberOfMoves;

    public void move() {
        numberOfMoves++;
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= condition;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
}
