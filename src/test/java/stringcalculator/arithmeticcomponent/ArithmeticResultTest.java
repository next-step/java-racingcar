package stringcalculator.arithmeticcomponent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("수식의 결과를 위한 테스트")
class ArithmeticResultTest {

    @DisplayName("수식의 계산 결과 변수로 int 값의 범위 안에 있는 값이 할당되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, 1, 100, Integer.MAX_VALUE})
    void checkValidResultTest(int number) {
        // When
        ArithmeticResult arithmeticResult = new ArithmeticResult(number);

        // Then
        assertAll(
                () -> assertThat(arithmeticResult).isNotNull(),
                () -> assertThat(arithmeticResult.getNumber()).isEqualTo(number)
        );
    }
}
