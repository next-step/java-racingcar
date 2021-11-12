package racinggame.domain;

@FunctionalInterface
public interface StateGenerator {
    State getState();
}
