package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameSetting;
import racingcar.policy.MovingPolicy;
import racingcar.policy.RandomMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSettingTest {

    private String CAR_NAMES = "pobi,crong,honux";

    @DisplayName("이동 정책이 null일 경우 기본정책인 랜덤으로 세팅한다.")
    @Test
    void settingMovingPolicy() {
        final MovingPolicy movingPolicy = null;
        RacingGameSetting setting = new RacingGameSetting(movingPolicy, CAR_NAMES, 0);
        assertThat(setting.getMovingPolicy()).isNotNull();
        assertThat(setting.getMovingPolicy()).isInstanceOf(RandomMovingPolicy.class);
    }

    @DisplayName("자동차 이름 문자열을 Cars 객체로 변환할 수 있다.")
    @Test
    void settingCars() {
        RacingGameSetting setting = new RacingGameSetting(null, CAR_NAMES, 0);
        assertThat(setting.getCars()).isNotNull();
        assertThat(setting.getCars()).isInstanceOf(Cars.class);
    }

    @DisplayName("자동차 이름갯수 만큼 자동차가 생성된다.")
    @Test
    void carCount() {
        final int length = CAR_NAMES.split(",").length;
        RacingGameSetting setting = new RacingGameSetting(null, CAR_NAMES, 0);
        assertThat(setting.getCars().toList()).hasSize(length);
    }
}