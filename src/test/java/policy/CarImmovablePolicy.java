package policy;

public class CarImmovablePolicy implements CarMovementPolicy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
