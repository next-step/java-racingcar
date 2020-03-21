package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("InputView 생성시 입력값 체크(1보다 크고 정수) : success")
    @ParameterizedTest
    @CsvSource(value = {"2:2", "3:3", "42:4"}, delimiter = ':')
    public void validateInputData_success(String param1, String param2) throws Exception {
        //when
        //then
        new InputView(param1, param2);
    }

    @DisplayName("InputView 생성시 입력값 체크(1보다 크고 정수) : fail")
    @ParameterizedTest
    @CsvSource(value = {"0:-2", "a:2.2", "42d:4"}, delimiter = ':')
    public void validateInputData_fail(String param1, String param2) throws Exception {
        //when
        //then
        assertThatThrownBy(() -> {
            new InputView(param1, param2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
