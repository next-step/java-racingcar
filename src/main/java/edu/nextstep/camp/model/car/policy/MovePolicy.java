package edu.nextstep.camp.model.car.policy;

@FunctionalInterface
public interface MovePolicy {
    boolean needToMove();
}
