package com.ssabae.nextstep.racingcar.step03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-07
 */
@DisplayName("Car 객체 이동하는 Operator Test Class")
class MoveOperatorTest {

    private final Operator<MoveState> operator = new MoveOperator(0, 9, 4);

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("숫자에 따른 판정 테스트 - (GO)")
    @ValueSource(ints = {4, 9})
    void shouldBeGoOperatorTest(int number) {
        MoveState state = operator.operate(number);
        assertThat(state).isEqualTo(MoveState.GO);
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("숫자에 따른 판정 테스트 - (STAY)")
    @ValueSource(ints = {0, 3})
    void shouldBeStayOperatorTest(int number) {
        MoveState state = operator.operate(number);
        assertThat(state).isEqualTo(MoveState.STAY);
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("숫자에 따른 판정 테스트 - (throw Exception)")
    @ValueSource(ints = {-1, 10})
    void shouldBeExceptionOperatorTest(int number) {
        assertThatThrownBy(() -> operator.operate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("움직일 수 있는 숫자의 허용범위는 0~9 까지입니다.");
    }

}
