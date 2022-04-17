package racingcar;


public class Car {
    private static final int MIN_NUMBER_BE_MOVES = 4;
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    private void move() {
        this.distance += 1;
    }

    private boolean canBeMove(int value) {
        return (value >= MIN_NUMBER_BE_MOVES);
    }

    public void play(int number) {
        if(canBeMove(number)) {
            move();
        }
    }
}
