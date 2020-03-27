package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputTest {
    private static final String CAR_NAMES_DUMMY = "a,b,c";

    @DisplayName("생성자 테스트 : success")
    @ParameterizedTest
    @CsvSource(value = {"2:a,b", "3:a,b,c", "4:a,b,c,d,e"}, delimiter = ':')
    public void constructor(int gameCount, String carNames) throws Exception {
        //when
        //then
        new UserInput(carNames, gameCount);
    }

    @DisplayName("생성자 테스트 : fail")
    @ParameterizedTest
    @CsvSource(value = {"0:a,b", "-1:a,b", "-10:a,c"}, delimiter = ':')
    public void constructor_fail(int gameCount, String carNames) throws Exception {
        //then
        assertThatThrownBy(() -> {
            new UserInput(carNames, gameCount);
        }).isInstanceOf(Exception.class);
    }

    @DisplayName("게임수 비교 생성자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5", "10:10"}, delimiter = ':')
    public void gameCount(int gameCount, int expect) throws Exception {
        //then
        assertThat(new UserInput(CAR_NAMES_DUMMY, gameCount).getGameCount()).isEqualTo(expect);
    }

    @DisplayName("자동차 이름 갯수 비교 생성자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a:1", "a,b,c:3", "a,b,c,d,e:5"}, delimiter = ':')
    public void carNames(String carNames, int expect) throws Exception {
        //then
        assertThat(new UserInput(carNames, 1).getCarNames().size()).isEqualTo(expect);
    }
}
