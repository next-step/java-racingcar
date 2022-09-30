package racingcar;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public int tryMove() {
        return tryMove(RandomGenerator.makeRandomValue());
    }

    public int tryMove(int value) {
        if (MovingCondtion.isMove(value)) {
            move();
        }
        return position;
    }
}
