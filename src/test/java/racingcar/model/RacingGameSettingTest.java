package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.policy.MovingPolicy;
import racingcar.policy.RandomMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSettingTest {

    @DisplayName("이동 정책이 null일 경우 기본정책인 랜덤으로 세팅한다.")
    @Test
    void settingMovingPolicy() {
        final MovingPolicy movingPolicy = null;
        RacingGameSetting setting = new RacingGameSetting(movingPolicy);
        assertThat(setting.getMovingPolicy()).isNotNull();
        assertThat(setting.getMovingPolicy()).isInstanceOf(RandomMovingPolicy.class);
    }
}