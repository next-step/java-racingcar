package racingcar.domain;

public interface Observer<T> {
    void observe(T event);
}
