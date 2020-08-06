package racing.domain;

@FunctionalInterface
public interface CarConsumer {
    void accept(String carName, int distance);
}
