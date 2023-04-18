package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ClientResponseTest {

    @ParameterizedTest(name = "[{index}] (,)구분자를 기준 차량 1대 이상 입력시 객체를 정상적으로 생성한다.")
    @ValueSource(strings = {"rick,jack,ethan", "ethan"})
    void objectCreateSuccessTest(String carNameChunk) {
        ClientResponse clientResponse = new ClientResponse(carNameChunk, 5);
        assertThat(clientResponse).isInstanceOf(ClientResponse.class);
    }

    @ParameterizedTest(name = "[{index}] 시도 횟수가 0 이하일 경우 객체 생성시 예외를 발생시킨다. try : {1}")
    @CsvSource(value = {"rick,jack,ethan:-1", "ethan:0"}, delimiter = ':')
    void objectCreateFailTest(String carNameChunk, int numberOfTries) {
        assertThatThrownBy(() -> new ClientResponse(carNameChunk, numberOfTries))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상의 숫자만 가능합니다.");
    }

}
