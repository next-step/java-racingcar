package car.racing;

public class CarForwardable implements Forwardable {

    private static final int THRESHOLD = 4;

    @Override
    public boolean forwardable(int forward) {
        return forward >= THRESHOLD;
    }
}
