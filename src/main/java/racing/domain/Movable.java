package racing.domain;

public interface Movable<T> {
    int moveForwardOrStop(T t);
}
