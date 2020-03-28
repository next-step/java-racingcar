package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("soojung","---");
    }

    @DisplayName("같은 자동차가 생성되었는지 확인해본다.")
    @Test
    void sameCar(){
       assertThat(car).isEqualTo(new Car("soojung","---"));
    }

    @DisplayName("경주한 자동차중 최대 값과 비교하여 같은 경우")
    @Test
    void isSameMaxRacingResult() {
        assertThat(car.isSame("---")).isTrue();
    }


    @DisplayName("경주한 자동차중 최대 값과 비교하여 같지 않은 경우")
    @Test
    void isNotSameMaxRacingResult() {
        assertThat(car.isSame("-----")).isFalse();
    }
}
