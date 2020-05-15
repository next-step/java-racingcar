package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Racingcar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createRacingCarTest() {
        Racingcar racingcar = new Racingcar(0);
        assertThat(0).isEqualTo(racingcar.getCarNumber());
    }

}
