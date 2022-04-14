package racingcar.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.RacingCar;


import static org.assertj.core.api.Assertions.assertThat;

class ZeroToNineRandomPolicyTest {

    static final RacingGamePolicy racingGamePolicy = new ZeroToNineRandomPolicy();

    @Test
    @DisplayName("0-9 랜덤 정책 테스트")
    void racing() {

        RacingCar racingCar = new RacingCar(0, 3);

        int result = racingGamePolicy.racing(racingCar.getProgress(), 10);
        assertThat(result).isGreaterThanOrEqualTo(racingCar.getProgress());
    }
}