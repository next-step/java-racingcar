package autoracing.domain;

@FunctionalInterface
public interface RacingRule {
    boolean canGoForward();
}
