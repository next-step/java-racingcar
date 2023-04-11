package step3.service;

public class RacingCarForwardMatcher implements GameMatcher {

    public static final int CAR_FORWARD_MINIMUM_NUMBER = 4;

    @Override
    public boolean match(int random) {
        return random >= CAR_FORWARD_MINIMUM_NUMBER;
    }
}
