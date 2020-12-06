package com.ssabae.nextstep.racingcar.step03.domain;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-07
 */
public class CarPrinter {

    void print(Car car) {
        int moveCount = car.getMoveCount();
        StringBuilder moving = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            moving.append("-");
        }
        System.out.println(moving);
    }
}
