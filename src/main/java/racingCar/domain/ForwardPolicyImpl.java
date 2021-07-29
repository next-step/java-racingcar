package racingCar.domain;

public class ForwardPolicyImpl implements ForwardPolicy {
    public static final int THRETHOLD = 4;
    @Override
    public boolean isMovableNumber(int number) {
        return number >= THRETHOLD;
    }
}
