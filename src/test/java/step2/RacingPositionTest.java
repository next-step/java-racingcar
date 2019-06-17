package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingPositionTest {

    private RacingPosition racingPosition;

    @BeforeEach
    void init(){
        racingPosition = new RacingPosition();
    }

    @Test
    @DisplayName("0~10까지 랜덤 숫자 가져오기 테스트")
    void carPositionSatatusTest(){
        int randomNumber = racingPosition.carPositionSatatus();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("입력 된 숫자에 따른 자동차 움직임 테스트 4보다 작을 경우 테스트")
    void carPositionUpdateValueDownTest() {
        int randomNumber = 3;
        int moveNumber = racingPosition.carPositionUpdateValue(randomNumber);

        assertThat(moveNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 된 숫자에 따른 자동차 움직임 테스트 4보다 크거나 같을 경우 테스트")
    void carPositionUpdateValueUpTest() {
        int randomNumber = 4;
        int moveNumber = racingPosition.carPositionUpdateValue(randomNumber);

        assertThat(moveNumber).isEqualTo(1);
    }

}
