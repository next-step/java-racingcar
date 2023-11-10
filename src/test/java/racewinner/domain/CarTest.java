package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차가 이동 할 때, MoveStrategy가 True면 Position은 증가한다.")
    @Test
    void goTest() {
        // given
        final Car car = new Car("popo", () -> true);

        // when
        car.move();

        // then
        assertThat(car.currentPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("자동차가 이동 할 때, MoveStrategy가 False면 Position은 증가하지 않는다.")
    @Test
    void stopTest() {
        // given
        final Car car = new Car("popo", () -> false);

        // when
        car.move();

        // then
        assertThat(car.currentPosition()).isEqualTo(new Position(0));
    }
    @DisplayName("isMaxPositionTest()에 입력되는 Position보다 더 높으면 True를 반환한다.")
    @Test
    void isMaxPositionTest() {
        // given
        final Car popo = new Car("popo", new Position(3), () -> true);

        // when
        // then
        assertThat(popo.isMaxPosition(new Position(2))).isTrue();
        assertThat(popo.isMaxPosition(new Position(5))).isFalse();
    }

    @DisplayName("isWinnerTest()의 인자로 들어오는 max position과 일치하면 True를 반환한다.")
    @Test
    void isWinnerTest() {
        // given
        final Car popo = new Car("popo", new Position(1), () -> true);

        // when
        // then
        assertThat(popo.isWinner(new Position(1))).isTrue();
    }

}