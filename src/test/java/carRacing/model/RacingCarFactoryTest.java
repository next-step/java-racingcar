package carRacing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarFactoryTest {

    @Test
    @DisplayName("자동차 옳바른 개수의 자동차생성")
    public void raceCarsTest() {
        String[] carName = {"ferrari", "benz", "bmw"};
        RacingCarFactory racingCarFactory = new RacingCarFactory(carName);
        assertThat(racingCarFactory.getRacingCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("null 입력 예외처리")
    public void emptyCarNamesException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new RacingCarFactory(null);
        });
    }
}