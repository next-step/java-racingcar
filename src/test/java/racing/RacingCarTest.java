package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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


    @ParameterizedTest
    @DisplayName("랜덤값이 4 이상일 때 전진")
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true",
            "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진_조건(int randomNumber, boolean canMove) {
        assertThat(RacingCar.canMove(randomNumber)).isEqualTo(canMove);
    }

}
