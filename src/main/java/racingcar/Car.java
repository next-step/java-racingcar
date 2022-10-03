package racingcar;

public class Car {
    private int position;

    private NumberGenerator numberGenerator;

    public Car() {
        this(new RandomGenerator());
    }

    public Car(NumberGenerator generator) {
        this.position = 0;
        this.numberGenerator = generator;
    }

    private void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public int tryMove() {
        if (MovingCondtion.isMove(numberGenerator.makeValue())) {
            move();
        }
        return position;
    }
}
