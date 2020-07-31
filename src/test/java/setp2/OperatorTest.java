package setp2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static setp2.Operator.calculate;

@DisplayName("연산 Test")
public class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2:+:1:3",
                        "2:-:1:1",
                        "2:*:1:2",
                        "2:/:1:2"},
               delimiter = ':')
    public void operation_success(int num1,
                                  String operator,
                                  int num2,
                                  int result) {
        assertThat(calculate(num1, operator, num2)).isEqualTo(result);
    }
}
