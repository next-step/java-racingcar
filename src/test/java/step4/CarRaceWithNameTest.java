package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.vehicle.Car;
import step4.vehicle.Cars;

public class CarRaceWithNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름입력_테스트(String input) {
        Cars car = new Cars(input.split(","));
        Assertions.assertThat(car).hasNoNullFieldsOrProperties();
    }

    @ParameterizedTest
    @ValueSource(strings = {"violin", ""})
    @DisplayName("자동차 이름 입력 테스트(공백)")
    void 자동차_이름입력_테스트_범위_밖(String input) {
        Assertions.assertThatThrownBy(() -> new Car(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("길이가 1이상 5이하인 문자열이여야 함");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("우승자 테스트")
    void 우승자_찾기(String input) {
        Cars cars = new Cars(input.split(","));
        cars.getCars().get(0).move(() -> 5);
        cars.getCars().get(1).move(() -> 1);
        cars.getCars().get(2).move(() -> 1);

        Assertions.assertThat(cars.getWinners()).hasSize(1);

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("우승자(2명이상) 테스트")
    void 우승자_찾기_2명_이상(String input) {
        Cars cars = new Cars(input.split(","));
        cars.getCars().get(0).move(() -> 5);
        cars.getCars().get(1).move(() -> 5);
        cars.getCars().get(2).move(() -> 1);

        Assertions.assertThat(cars.getWinners()).hasSize(2);

    }

}
