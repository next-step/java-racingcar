package CarRacing.domain;

public class NonMovingStrategy implements RacingStrategy {

    @Override
    public boolean movable() {
        return false;
    }
}
