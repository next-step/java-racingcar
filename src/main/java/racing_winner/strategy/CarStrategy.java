package racing_winner.strategy;

public interface CarStrategy {
    boolean isUsable(String name);

    boolean isUsable(int distance);
}
