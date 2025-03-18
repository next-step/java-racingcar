package policy;

public class CarMovabilityPolicy implements CarMovementPolicy {

    @Override
    public boolean isMovable() {
        return true;
    }
}
