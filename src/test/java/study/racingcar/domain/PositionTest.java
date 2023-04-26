package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("객체 생성시 0 초기화 테스트")
    @Test
    void when_initialize_position_object() {
        // given
        Position position = new Position();

        //when, then
        assertThat(position).isEqualTo(new Position());
    }

    @DisplayName("increase 한번 호출 시 position 값 1인지 테스트")
    @Test
    void when_calling_increase_once() {
        // given
        Position position = new Position();

        // when
        position.increase();

        // then
        assertThat(position).isEqualTo(new Position(1));
    }
}