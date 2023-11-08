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

    @DisplayName("경주가 시작하면 임의의 수를 전달 받아 자동차를 앞으로 움직인다.")
    @Test
    void startRace() {
        // given
        CarRacing carRacing = new CarRacing();
        int numOfCars = 6;
        carRacing.createCarsOf(numOfCars);

        // when
        for (int i=0; i<numOfCars; i++) {
            carRacing.moveCar(i, i);
        }

        // then
        for (int i=0; i<numOfCars; i++) {
            if (i < 4) {
                assertThat(carRacing.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(0);
                continue;
            }

            assertThat(carRacing.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(1);
        }
    }
}
