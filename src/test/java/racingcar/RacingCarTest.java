package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 게임 테스트")
public class RacingCarTest {

    @Test
    @DisplayName("주어진 횟수는 0 이상이어야 한다.")
    void roundCountTest() {
    }

    @Test
    @DisplayName("사용자가 입력한 자동차는 1대 이상이어야 한다.")
    void carCountTest() {
    }

    @Test
    @DisplayName("랜덤으로 생성한 값의 범위는 0~9이어야 한다.")
    void randomNumberTest() {
    }

    @Test
    @DisplayName("랜덤으로 생성한 값의 범위가 0~9가 아닐경우 에러가 발생한다.")
    void randomNumberFailTest() {
    }

    @Test
    @DisplayName("랜덤으로 생성한 값이 4 이상일 경우 전진해야한다.")
    void carMoveTest() {
    }

    @Test
    @DisplayName("자동차의 초기 상태는 0이어야 한다.")
    void carStateTest() {
    }

    @Test
    @DisplayName("자동차의 현재 상태는 주어진 횟수값을 넘을 수 없다.")
    void carStateFailTest() {
    }
}
