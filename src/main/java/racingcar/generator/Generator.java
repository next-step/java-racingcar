package racingcar.generator;

public interface Generator<T1, T2> {
    T1 generate(T2 value);
}
