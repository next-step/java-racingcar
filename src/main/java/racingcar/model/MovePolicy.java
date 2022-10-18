package racingcar.model;

@FunctionalInterface
public interface MovePolicy {

    Distance getSteps();

}
