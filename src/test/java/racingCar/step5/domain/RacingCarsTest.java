package racingCar.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @DisplayName(",를 문자열을 분리하여 이름의 수만큼 차 생성이 가능하다")
    @Test
    void createCarWithNames(){
        RacingCars cars = RacingCars.ofNames("aa,bb,cc");
        assertThat(cars.countCars()).isEqualTo(3);
    }
}
