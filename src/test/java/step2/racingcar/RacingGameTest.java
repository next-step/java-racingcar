/*
 * Description :  자동차경주중 자동차들의 기능이 제대로 수행되는지 테스트
 */

package step2.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private RacingGame racingGame;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
        inputView = new InputView();
    }

    @DisplayName("자동차개수를 입력하였을때, int배열이 return 되는지 확인")
    @Test
    void validateTrackSetting() {
        int carCount = 1;
        assertThat(racingGame.markCarOnTrack(1)).isInstanceOf(int[].class);
    }

}
