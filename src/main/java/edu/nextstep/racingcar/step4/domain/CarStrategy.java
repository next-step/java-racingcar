package edu.nextstep.racingcar.step4.domain;

import java.util.Random;

public class CarStrategy implements MoveStrategy {

    @Override
    public boolean isMove(int numberOfRandoms, int threshold) {
        return new Random().nextInt(numberOfRandoms) >= threshold;
    }
}
