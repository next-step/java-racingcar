package study.step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.exception.InputParserException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputParserTest {

    @ParameterizedTest(name = "입력값_파싱_성공_테스트: {0}")
    @CsvSource(value = {
        "그랜져,소나타,K5:3",
        "그랜져, 소나타, K5:3",
        "그랜져,소나타:2",
        "그랜져 , 소나타:2",
        "그랜져:1",
    }, delimiter = ':')
    void 입력값_파싱_성공(String carNames, int result) {
        assertThat(InputParser.parse(carNames)).hasSize(result);
    }

    @ParameterizedTest(name = "공백_입력_테스트: {0}")
    @ValueSource(strings = {
        "그랜져,,K5",
        "",
        ",그랜져",
    })
    void 공백_입력(String carNames) {
        assertThatExceptionOfType(InputParserException.class)
            .isThrownBy(() -> InputParser.parse(carNames))
            .withMessageContaining("InputParserError");
    }
}
