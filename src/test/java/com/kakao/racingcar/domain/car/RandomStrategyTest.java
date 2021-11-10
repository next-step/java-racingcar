package com.kakao.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomStrategyTest {

    @Test
    @DisplayName("기준 숫자 4보다 크거나 같을 경우에만 차가 움직이는 조건을 설정한다.")
    void move() {
        RandomStrategy randomStrategy = new RandomStrategy();
        boolean move = randomStrategy.move(4);
        assertThat(move).isTrue();
    }

    @Test
    @DisplayName("기준 숫자보다 더 작을 경우엔 차가 움직이지 않는 조건을 설정한다..")
    void moveFail() {
        RandomStrategy randomStrategy = new RandomStrategy();
        boolean move = randomStrategy.move(3);
        assertThat(move).isFalse();
    }
}
