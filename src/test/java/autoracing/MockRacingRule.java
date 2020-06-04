package autoracing;

public class MockRacingRule implements RacingRule {
    private final boolean canGoForward;

    MockRacingRule(boolean canGoForward) {
        this.canGoForward = canGoForward;
    }

    @Override
    public boolean canGoForward() {
        return canGoForward;
    }
}
