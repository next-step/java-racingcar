package race.domain;

public class FixedGoCondition implements GoCondition {
    private final boolean canGo;

    public FixedGoCondition(boolean canGo) {
        this.canGo = canGo;
    }

    @Override
    public boolean canGo() {
        return canGo;
    }
}
