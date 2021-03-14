package new_racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InputView 입력 테스트")
class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp(){
        inputView = new InputView();
    }

    // TODO : UI 경주에 참가할 자동차 수가 유효성 성공 확인 -> 문자열로 변경됨
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("입력받은 참가 선수 1명 이상이면 유효성 성공 확인")
    public void playerNumberValidSuccesstest(int playerCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(playerCount)).isTrue();
    }

    // TODO : UI 경주에 참가할 자동차 수 유효성 실패 확인 -> 문자열로 변경됨
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력받은 참가 선수 1명 미만이면 유효성 실패 확인")
    public void playerNumberValidFailtest(int playerCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(playerCount)).isFalse();
    }

    // TODO : UI 경주에 참가할 자동차 수가 유효성 성공 확인
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("입력받은 진행 횟수 1 이상이면 유효성 성공 확인")
    public void turnCountValidSuccesstest(int turnCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(turnCount)).isTrue();
    }

    // TODO : UI 경주에 참가할 자동차 수 유효성 실패 확인
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력받은 진행 횟수 1 미만이면 유효성 실패 확인")
    public void turnCountValidFailtest(int turnCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(turnCount)).isFalse();
    }
}