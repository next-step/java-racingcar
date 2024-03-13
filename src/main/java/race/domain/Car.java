package race.domain;

public class Car {
    private final int CONDITION_OF_MOVE = 4;
    private int countOfMove;

    private Car() {

    }

    public static Car createInstance() {
        return new Car();
    }

    public void move(int number) {
        if(!canMove(number)) {
            return;
        }
        countOfMove++;
    }

    private boolean canMove(int number) {
        return number >= CONDITION_OF_MOVE;
    }

    public int getCountOfMove() {
        return countOfMove;
    }
}
