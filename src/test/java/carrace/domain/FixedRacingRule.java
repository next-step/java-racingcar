package carrace.domain;

public class FixedRacingRule implements RacingRule {
    @Override
    public int generateNumber() {
        return 6;
    }
}
