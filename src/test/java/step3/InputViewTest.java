package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
//input값을 확인하기 위한 TDD
//    @DisplayName("요청한 input값 과 결과값 동일 여부")
//    @Test
//    void resultValue(String content, int inputNumber){
//        assertThat(InputView.input(InputView.LOOP_COUNT_MESSAGE)).
//    }

    @DisplayName("Input값 유효성 검사 여부")
    @ParameterizedTest
    @MethodSource("inputNumberCase")
    void validInputNum(boolean expect, int inputNumber) {
        assertThat(InputView.isValidInputNumber(inputNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputNumberCase() {
        return Stream.of(
                Arguments.of(false, 7),
                Arguments.of(true, 0)
        );
    }
}
