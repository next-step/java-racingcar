package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @DisplayName("사용자에게 생성할 자동차 수를 입력받아 List에 저장한다.")
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
}
