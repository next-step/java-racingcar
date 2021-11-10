package com.kakao.racingcar.domain.car;

@FunctionalInterface
public interface MovableStrategy {
    boolean move(int conditionNumber);
}
