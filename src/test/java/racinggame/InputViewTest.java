package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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


    @DisplayName("입력 받은 car의 수만큼 list 사지즈가 생성 되었는지")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "2:2:2", "42:42:42"}, delimiter = ':')
    public void validateInputData_fail(String param1, String param2, int expect) throws Exception {
        //when
        InputView inputView = new InputView(param1, param2);

        //then
        assertThat(inputView.getCars().size()).isEqualTo(expect);
    }
}
