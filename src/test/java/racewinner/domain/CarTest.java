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
    @DisplayName("isMaxPositionTest()의 인자로 더 높은 Position이 들어오면 True를 반환한다.")
    @Test
    void isMaxPositionTest() {
        // given
        final Car popo = new Car("popo", () -> true);
        final Car bobo = new Car("bobo", () -> true);

        // when
        popo.move();

        // then
        assertThat(popo.isMaxPosition(bobo.currentPosition())).isTrue();
    }

    @DisplayName("isWinnerTest()의 인자로 들어오는 max position과 일치하면 True를 반환한다.")
    @Test
    void isWinnerTest() {
        // given
        final Car popo = new Car("popo", () -> true);

        // when
        popo.move();

        // then
        assertThat(popo.isWinner(new Position(1))).isTrue();
    }

}