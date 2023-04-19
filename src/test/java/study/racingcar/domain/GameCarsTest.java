package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameCarsTest {

    @DisplayName("리스트의 크기 만큼 Car 객체를 생성하는지 테스트")
    @Test
    void when_input_list_size_is_given() {
        // given
        List<String> carNames = List.of("pobi", "junho", "crong", "honux");

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(carNames.size());
    }

    @DisplayName("리스트 크기가 1일 경우 컬렉션 크기 1 검증")
    @Test
    void when_input_list_size_is_one() {
        // given
        List<String> carNames = List.of("pobi");

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(1);
    }

    @DisplayName("empty list일 경우 컬렉션 크기 0인지 검증")
    @Test
    void when_input_list_is_empty() {
        // given
        List<String> carNames = List.of();

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(0);
    }
}