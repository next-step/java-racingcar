package racinggame.domain.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InputViewTest {

    private static final String CAR_NAMES_DUMMY = "a,b,c";

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

    @DisplayName("게임수 비교 생성자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5", "10:10"}, delimiter = ':')
    public void gameCount(String gameCount, int expect) throws Exception {
        //then
        assertThat(new InputView(gameCount, CAR_NAMES_DUMMY).getGameCount()).isEqualTo(expect);
    }

    @DisplayName("자동차 이름 갯수 비교 생성자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a:1", "a,b,c:3", "a,b,c,d,e:5"}, delimiter = ':')
    public void carNames(String carNames, int expect) throws Exception {
        //then
        assertThat(new InputView("1", carNames).getCarNames().size()).isEqualTo(expect);
    }
}
