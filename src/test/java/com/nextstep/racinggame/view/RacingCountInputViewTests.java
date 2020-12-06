package com.nextstep.racinggame.view;

import com.nextstep.racinggame.view.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCountInputViewTests {
    @DisplayName("숫자를 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int racingCount = 2;

        assertThat(new RacingCountInputView(racingCount)).isNotNull();
    }

    @DisplayName("유효하지 않은 숫자로 객체 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createFailTest(int invalidValue) {
        assertThatThrownBy(() -> new RacingCountInputView(invalidValue)).isInstanceOf(InvalidUserInputException.class);
    }
}
