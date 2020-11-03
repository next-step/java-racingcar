package car.racing;

public class ForwardableImpl implements Forwardable {

    private static final int THRESHOLD = 4;

    @Override
    public boolean forwardable(int forward) {
        return forward >= THRESHOLD;
    }
}
