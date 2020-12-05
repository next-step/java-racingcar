package racing.domain;

public class FixedPowerGenerator implements PowerGenerator {
    @Override
    public int generate() {
        return 4;
    }
}
