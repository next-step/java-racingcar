package step4;

public class RandomDrivingStrategy implements MovingStrategy {

    @Override
    public int move() {
        return NumberGenerator.createRandomNumbers();
    }
}
