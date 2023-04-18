package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private final String DEFAULT_CAR_NAME = "kgh";

    @DisplayName("3단계 - 자동차 경주 - 레이싱 자동차 객체가 생성되는지 확인")
    @Test
    void create_racing_cars() {
        assertThat(RacingCars.create(Collections.singletonList(new Car(DEFAULT_CAR_NAME)))).isNotNull();
    }
}
