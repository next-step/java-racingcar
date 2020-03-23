package racinggame.domain.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {

    @DisplayName("InputView 생성자 테스트 : success")
    @ParameterizedTest
    @CsvSource(value = {"2:a,b", "3:a,b,c", "4:a,b,c,d,e"}, delimiter = ':')
    public void inputView_success(String gameCount, String carNames) throws Exception {
        //when
        //then
        new InputView(gameCount, carNames);
    }

    @DisplayName("InputView 생성자 테스트 : fail")
    @ParameterizedTest
    @CsvSource(value = {"0:a,b", "-1:a,b", "a:a,b"}, delimiter = ':')
    public void inputView_fail(String gameCount, String carNames) throws Exception {
        //then
        assertThatThrownBy(() -> {
            new InputView(gameCount, carNames);
        }).isInstanceOf(Exception.class);
    }
}
