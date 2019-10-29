package study.first;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperationMethodTest {

    @DisplayName("OperationMethod 가 모두 맞는 값")
    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void rightMethod(String method, String result) {
        assertThat(OperationMethod.of(method).name()).isEqualTo(result);
    }


    @DisplayName("OperationMethod 다른 값")
    @Test
    void wrongMethod() {
        assertThatIllegalArgumentException().isThrownBy(() -> OperationMethod.of("%"));
    }
}
