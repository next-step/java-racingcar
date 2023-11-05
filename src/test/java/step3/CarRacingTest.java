package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @DisplayName("사용자에게 생성할 자동차 수를 입력받아 해당 길이의 배열을 생성한다.")
    @Test
    void createCars() {
        // given
        CarRacing carRacing = new CarRacing();
        int numOfCars = 5;

        // when
        carRacing.createCarsOf(numOfCars);

        // then
        assertThat(carRacing.getRacingCars().length).isEqualTo(5);
    }

    @DisplayName("사용자에게 시도할 횟수를 입력받아 해당 횟수만큼 엑셀을 밟는다.")
    @Test
    void startRace() {
        // given
        CarRacing carRacing = new CarRacing();
        int numOfCars = 5;
        int numOfTry = 5;
        carRacing.createCarsOf(numOfCars);

        // when
        carRacing.tryMove(numOfTry);

        // then
        Arrays.stream(carRacing.getRacingCars())
            .forEach(car -> assertThat(car.getCurrentPosition()).isBetween(1, 6));
    }
}
