package study.racingcar.strategy;

@FunctionalInterface
public interface NumberGenerator {
    int MOVABLE_LOWER_BOUND = 4;
    int generate();
}