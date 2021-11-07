package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.utils.NumberUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    RacingCarGame racingCarGame;

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(3, 5);
    }

    @Test
    void playTest() {
        racingCarGame.play();
    }

    @DisplayName("0~9까지의 랜덤 숫자 생성 테스트")
    @Test
    void randomTest() {
        assertThat(NumberUtils.getRandomNumber()).isBetween(0, 9);
    }
}
