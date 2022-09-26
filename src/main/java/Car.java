import java.util.Random;

public class Car {

    private int currentPosition;
    private CarMoveCondition carMoveCondition;
    private Random random;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Car() {
        this.currentPosition = 0;
        this.carMoveCondition = new CarMoveCondition();
        this.random = new Random();
    }

    public void move() {
        int randomValue = random.nextInt(carMoveCondition.getMaxValue());
        if (carMoveCondition.checkMoveCondition(randomValue)) return;
        currentPosition++;
    }
}
