package edu.nextstep.camp.racinggame.domain.car.policy;

@FunctionalInterface
public interface MovePolicy {
    boolean needToMove();
}
