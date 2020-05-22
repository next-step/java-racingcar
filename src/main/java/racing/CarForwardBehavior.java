package racing;

public class CarForwardBehavior implements CarMoveBehavior {
    private final int BOUND_NUMBER = 10;
    private final int LIMIT_NUMBER = 4;

    @Override
    public boolean action() {
        return RandomNumber.getRandomNumber(BOUND_NUMBER) >= LIMIT_NUMBER;
    }
}
