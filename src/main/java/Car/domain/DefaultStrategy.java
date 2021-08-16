package Car.domain;

public class DefaultStrategy implements MovingStrategy{
    private final int MINNUMBER = 4;
    @Override
    public boolean isMove(int inputNumber) {
        return inputNumber >= MINNUMBER;
    }
}
