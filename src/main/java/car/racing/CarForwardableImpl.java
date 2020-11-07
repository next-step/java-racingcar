package car.racing;

public class CarForwardableImpl implements CarForwardable {

    private static final int THRESHOLD = 4;

    @Override
    public boolean forwardable(int forward) {
        return forward >= THRESHOLD;
    }
}
