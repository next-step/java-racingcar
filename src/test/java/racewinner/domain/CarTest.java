package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 이동 할 때, 4~9 값이 나오면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goTest(int number) {
        // given
        final Car popo = new Car("popo");

        // when
        popo.move(number);

        // then
        assertThat(popo.isWinner(new Position(1))).isTrue();
    }

    @DisplayName("자동차가 이동 할 때, 0~3 값이 나오면 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int number) {
        // given
        final Car popo = new Car("popo");

        // when
        popo.move(number);

        // then
        assertThat(popo.isWinner(new Position(0))).isTrue();
    }
    @DisplayName("max()는 더 높으면 Position을 반환한다.")
    @Test
    void isMaxPositionTest() {
        // given
        final Car popo = new Car("popo", new Position(3));

        // when
        // then
        assertThat(popo.max(new Position(1))).isEqualTo(new Position(3));
        assertThat(popo.max(new Position(5))).isEqualTo(new Position(5));
    }

    @DisplayName("isWinnerTest()의 인자로 들어오는 max position과 일치하면 True를 반환한다.")
    @Test
    void isWinnerTest() {
        // given
        final Car popo = new Car("popo", new Position(1));

        // when
        // then
        assertThat(popo.isWinner(new Position(1))).isTrue();
        assertThat(popo.isWinner(new Position(2))).isFalse();
    }

}