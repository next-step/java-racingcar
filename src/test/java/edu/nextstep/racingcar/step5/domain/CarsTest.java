package edu.nextstep.racingcar.step5.domain;

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

    @DisplayName("우승자 출력 테스트 (Default 전략)")
    @Test
    void getWInners() {
        cars.play(5, new DefaultMoveStrategy());
        assertThat(cars.getWinners()).isNotEmpty();
    }

    @DisplayName("우승자 출력 테스트 (전원 우승)")
    @Test
    void getWInners_again() {
        cars.play(5, () -> true);
        assertThat(cars.getWinners().size()).isEqualTo(5);
    }

    @DisplayName("Cars 객체 생성 테스트")
    @Test
    void create() {
        Cars cars = Cars.create("AAA,BBB,CCC,DDD,EEE");
        assertThat(cars.getCars().size()).isEqualTo(5);
    }
}