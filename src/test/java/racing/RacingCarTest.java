package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 수만큼 자동차 생성")
    void 자동차_생성() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.createCars(5)).hasSize(5);
    }


    @Test
    @DisplayName("입력받은 수만큼 자동차 행동")
    void 자동차_행동() {
        RacingCar racingCar = Mockito.spy(new RacingCar());

        racingCar.activeTurns(5);

        verify(racingCar, times(5)).activeCar();
    }

}
