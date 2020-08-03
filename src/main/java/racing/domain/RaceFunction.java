package racing.domain;

@FunctionalInterface
public interface RaceFunction {
    void compute(int movedDistance, int totalDistance);
}
