package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;

@DisplayName("자동차 경주 - CarNames 테스트")
class CarNamesTest {
    @Test
    void CarNames는_이름으로_생성이_가능하다() {
        assertThat(new CarNames(List.of(VALID_CAR_NAME, VALID_CAR_NAME)))
                .isInstanceOf(CarNames.class);
    }

    @Test
    void CarNames는_이름_문자열로_생성이_가능하다() {
        assertThat(CarNames.from(List.of(VALID_CAR_NAME.getName(), VALID_CAR_NAME.getName())))
                .isInstanceOf(CarNames.class);
    }

    @Test
    void CarNames는_1대_미만_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarNames(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void CarNames는_carNames없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarNames(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
