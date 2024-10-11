package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarRacing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 경주 준비 메서드 테스트")
    public void carRaceReadyTest() {
        CarRacing carRacing = new CarRacing(List.of("pobi", "crong", "honux"));
        assertThat(carRacing.getCars()).hasSize(3);
        assertThat(carRacing.getCars()).extracting(Car::getName).isEqualTo(List.of("pobi", "crong", "honux"));
    }

}
