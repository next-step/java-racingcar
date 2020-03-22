package racinggame.domain.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {

    @DisplayName("InputView 생성자 테스트 : success")
    @ParameterizedTest
    @CsvSource(value = {"2:2:a,b", "3:3:a,b,c", "5:4:a,b,c,d,e"}, delimiter = ':')
    public void inputView_success(String carCount, String gameCount, String carNames) throws Exception {
        //when
        //then
        new InputView(carCount, gameCount, carNames);
    }

    @DisplayName("InputView 생성자 테스트 : fail")
    @ParameterizedTest
    @CsvSource(value = {"2.1:2:a,b,c", "3:3:a,b,c,d", "42:4:a,b,c"}, delimiter = ':')
    public void inputView_fail(String carCount, String gameCount, String carNames) throws Exception {
        //then
        assertThatThrownBy(() -> {
            new InputView(carCount, gameCount, carNames);
        }).isInstanceOf(Exception.class);
    }
}
