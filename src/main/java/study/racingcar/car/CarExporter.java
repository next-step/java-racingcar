package study.racingcar.car;

public interface CarExporter<T> {

    void currentPosition(int currentPosition);

    T build();

}
