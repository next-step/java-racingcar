package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameSetting;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSettingTest {

    private String CAR_NAMES = "pobi,crong,honux";

    @DisplayName("자동차 이름 문자열을 Cars 객체로 변환할 수 있다.")
    @Test
    void settingCars() {
        RacingGameSetting setting = new RacingGameSetting(CAR_NAMES, 0);
        assertThat(setting.getCars()).isNotNull();
        assertThat(setting.getCars()).isInstanceOf(Cars.class);
    }

    @DisplayName("자동차 이름갯수 만큼 자동차가 생성된다.")
    @Test
    void carCount() {
        final int length = CAR_NAMES.split(",").length;
        RacingGameSetting setting = new RacingGameSetting(CAR_NAMES, 0);
        assertThat(setting.getCars().toList()).hasSize(length);
    }
}