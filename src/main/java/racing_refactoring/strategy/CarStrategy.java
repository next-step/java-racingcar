package racing_refactoring.strategy;

public interface CarStrategy {

    boolean underMinLength(String name);

    boolean underMinLength(int trial);

    boolean overMaxLength(String name);

    boolean underMinLength(String[] carNames);
}
