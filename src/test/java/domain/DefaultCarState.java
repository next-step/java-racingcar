package domain;

public class DefaultCarState implements CarState {
    public static DefaultCarState create() {
        return new DefaultCarState();
    }
}
