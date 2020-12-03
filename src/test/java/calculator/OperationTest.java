package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    @DisplayName("연산기호 불일치 test")
    void illegalOperatorTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operation op = Operation.of("#");
                }).withMessageMatching("\\S is not operator");
    }

    @ParameterizedTest
    @CsvSource({"+,+","20 - 10,10","20 * 10,200","20 / 10,2"})
    @DisplayName("정상적인 enum객체 반환 test")
    void operatorMatchTest() {
        assertAll("operation",
                () -> assertEquals(Operation.of("+"), Operation.ADDITION),
                () -> assertEquals(Operation.of("-"), Operation.SUBTRACTION),
                () -> assertEquals(Operation.of("*"), Operation.MULTIPLICATION),
                () -> assertEquals(Operation.of("/"), Operation.DIVISION));
    }

}
