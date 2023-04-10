import java.util.Random;

public class Car {

    private static final Random RANDOM_DICE = new Random();
    private static final int LEAST_RANDOM_VALUE = 4;
    private CarPosition position;

    public Car() {
        this.position = new CarPosition(0);
    }

    public void moveCar(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= LEAST_RANDOM_VALUE){
            this.position = position.move();
        }
    }

    public int getPositionValue() {
        return position.getPositionValue();
    }

    public int moveOrNot() {
        return RANDOM_DICE.nextInt(10);
    }
}
