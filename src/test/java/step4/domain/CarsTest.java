package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름입력_테스트(String input) {
        Cars car = new Cars(input.split(","));
        Assertions.assertThat(car).hasNoNullFieldsOrProperties();
        Assertions.assertThat(car.getCars()).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름입력_테스트_2명미만_예외발생(String input) {
        Assertions.assertThatThrownBy(() -> new Cars(input.split(",")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임을 진행할 수 없음");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("우승자 테스트")
    void 우승자_찾기(String input) {
        Cars cars = new Cars(input.split(","));
        cars.getCars().get(0).move(() -> 5);
        cars.getCars().get(1).move(() -> 1);
        cars.getCars().get(2).move(() -> 1);

        Assertions.assertThat(cars.findWinners()).hasSize(1);

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("우승자(2명이상) 테스트")
    void 우승자_찾기_2명_이상(String input) {
        Cars cars = new Cars(input.split(","));
        cars.getCars().get(0).move(() -> 5);
        cars.getCars().get(1).move(() -> 5);
        cars.getCars().get(2).move(() -> 1);

        Assertions.assertThat(cars.findWinners()).hasSize(2);
        Assertions.assertThat(cars.findWinners()).contains("pobi", "crong");

    }
}
