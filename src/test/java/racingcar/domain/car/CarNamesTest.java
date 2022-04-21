package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - CarNames 테스트")
class CarNamesTest {
    @Test
    void CarNames는_1대_미만_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarNames(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
