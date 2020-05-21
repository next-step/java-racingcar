package racingcar.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingScoreCardTest {

    private static String DEFAULT_NAME = "TEST";
    private static int DEFAULT_POSITION = 1;
    private RacingScoreCard racingScorecard;

    @BeforeEach
    void setUp() {
        racingScorecard = new RacingScoreCard(DEFAULT_NAME, DEFAULT_POSITION);
    }

    @DisplayName("만들어진 객체의 name을 정상적으로 얻을 수 있는 지 확인")
    @Test
    void getName() {
        assertThat(racingScorecard.getName()).isEqualTo(DEFAULT_NAME);
    }

    @DisplayName("만들어진 객체의 position을 정상적으로 얻을 수 있는 지 확인")
    @Test
    void getPosition() {
        assertThat(racingScorecard.getPosition()).isEqualTo(DEFAULT_POSITION);
    }
}