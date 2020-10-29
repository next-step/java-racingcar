package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ValidatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    /*
    - public 으로 하는 이유는 junit 이 해당 메서드를 관찰(사용)할 수 있게 함인가?
    - java 에서는 전역 변수를 어떻게 관리할까?
    - MethodSource @
    - Stream 의 메서드
    - test 와 실제 테스트 대상의 함수 이름의 통일성이 필요할 것 같다.
     */
    @DisplayName("사칙연산 가호에 해당되지 않을 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = "3 * 5 & 5")
    public void validateOperatorType(String inputData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(inputData);
                }).withMessageMatching("사칙연산 기호가 아닙니다.");
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @DisplayName("입력값이 null 이거나 비었을 때 예외처리")
    @ParameterizedTest
    @MethodSource("blankStrings")
    public void validateInputDataIsEmpty(String blankData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(blankData);
                }).withMessageMatching("입력 값이 비어있습니다.");
    }

}
