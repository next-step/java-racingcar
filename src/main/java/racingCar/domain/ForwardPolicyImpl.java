package racingCar.domain;

public class ForwardPolicyImpl implements ForwardPolicy {

    private static final int THRESHOLD = 4;

    @Override
    public boolean isMovableNumber(int number) {
        return number >= THRESHOLD;
    }
}
