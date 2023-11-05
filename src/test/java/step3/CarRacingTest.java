package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @DisplayName("사용자에게 입력받은 수만큼 자동차를 생성한다.")
    @Test
    void createCars() {
        // given
        CarRacing carRacing = new CarRacing();
        int numOfCars = 5;

        // when
        carRacing.createCarsOf(numOfCars);

        // then
        assertThat(carRacing.getCars().getNumOfCars()).isEqualTo(5);
    }

    @DisplayName("경주가 시작하면 자동차를 앞으로 움직인다.")
    @Test
    void startRace() {
        // given
        CarRacing carRacing = new CarRacing();
        int numOfCars = 5;
        carRacing.createCarsOf(numOfCars);

        // when
        carRacing.moveCar();

        // then
        for (int i=0; i<numOfCars; i++) {
            assertThat(carRacing.getCars()
                .findCarBy(i)
                .getCurrentPosition())
                .isBetween(0, 1);
        }
    }
}
