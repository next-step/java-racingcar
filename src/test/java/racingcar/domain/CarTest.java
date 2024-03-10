package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 테스트")
class CarTest {
    @DisplayName("자동차 최초 생성 시 포지션은 1이다")
    @Test
    void carHasPosition1AfterCreation() {
        // given
        final Car car = new Car();

        // when
        final int actual = car.getPosition();

        // then
        assertThat(actual).isOne();
    }

    @DisplayName("advance 메서드에 true를 전달하면 position이 1 증가한다")
    @Test
    void positionIncreasesWhenTruePassed() {
        // given
        final Car car = new Car();
        car.advance(true);

        // when
        final int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("advance 메서드에 false를 전달하면 position은 그대로 1이다")
    @Test
    void positionRemainsSameWhenFalsePassed() {
        // given
        final Car car = new Car();
        car.advance(false);

        // when
        final int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(1);
    }
}
