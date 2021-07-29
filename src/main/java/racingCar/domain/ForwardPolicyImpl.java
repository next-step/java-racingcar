package racingCar.domain;

public class ForwardPolicyImpl implements ForwardPolicy {

    public static final int THRESHOLD = 4;

    @Override
    public boolean isMovableNumber(int number) {
        return number >= THRESHOLD;
    }
}
