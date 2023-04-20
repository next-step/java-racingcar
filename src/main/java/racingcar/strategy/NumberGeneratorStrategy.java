package racingcar.strategy;

public interface NumberGeneratorStrategy {
    int generateNumber();

    boolean isMovable(int number);
}
