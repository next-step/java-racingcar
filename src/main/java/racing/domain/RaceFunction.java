package racing.domain;

@FunctionalInterface
public interface RaceFunction {
    void compute(String carName, int totalDistance);
}
