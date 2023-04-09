package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClientInputTest {

    @Test
    @DisplayName("2개의 파라미터 전부 1 이상의 정수값이 입력된경우 정상적으로 객체가 생성된다.")
    void objectCreateSuccessTest() {
        ClientInput clientInput = new ClientInput(3,5);
        assertThat(clientInput).isInstanceOf(ClientInput.class);
    }

    @ParameterizedTest(name = "[{index}]0 이하의 음수 값이 입력 되 었을 경우 예외를 발생한다 case [{0}, {1}]")
    @CsvSource(value = {"-1:1", "0:3", "-3:-3"},delimiter = ':')
    void objectCreateFailTest(int numberOfCars, int numberOfTries) {
        assertThatThrownBy(() -> {
            new ClientInput(numberOfCars,numberOfTries);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수값으론 경기를 진행할 수 없습니다.");
    }
}
