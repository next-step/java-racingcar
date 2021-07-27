package edu.nextstep.racingcar.step4.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static Cars cars;

    @BeforeAll
    static void getCars() {
        cars = Cars.create("AAA,BBB,CCC,DDD,EEE");
    }

    @DisplayName("우승자 출력 테스트")
    @Test
    void getWInners() {
        cars.play(5, new DefaultMoveStrategy());
        assertThat(cars.getWinners()).isNotEmpty();
    }
}