package racingcar.domain;

@FunctionalInterface
public interface MovePolicy {

    Distance getSteps();

}
