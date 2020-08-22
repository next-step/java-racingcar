package race.domain;

@FunctionalInterface
public interface AdvanceCondition {
    boolean canAdvance();
}
