package step4_racintCarWithWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameUtilsTest {

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    public void handleInputCarNames(){
        assertThat(RacingGameUtils.stringsSplitBy("루피,조로,초파",","))
                .isEqualTo(new String[]{"루피", "조로", "초파"});
    }
}
