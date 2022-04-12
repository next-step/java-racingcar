package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MovementCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("움직임 규칙을 만족하면 이동 가능한 플래그를 전달한다")
    void canMove(int number) {
        //given
        MovementChecker movementChecker = new MovementChecker();

        //when
        boolean movable = movementChecker.canMove(number);

        //then
        assertThat(movable).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("움직임 규칙을 만족하면 이동 가능한 플래그를 전달한다")
    void canNotMove(int number) {
        //given
        MovementChecker movementChecker = new MovementChecker();

        //when
        boolean movable = movementChecker.canMove(number);

        //then
        assertThat(movable).isFalse();
    }

}