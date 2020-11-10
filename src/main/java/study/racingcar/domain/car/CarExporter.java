package study.racingcar.domain.car;

public interface CarExporter<T> {

    void name(String name);

    void currentPosition(int currentPosition);

    T build();

}
