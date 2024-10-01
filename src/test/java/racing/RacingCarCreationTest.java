package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCreationTest {

    @DisplayName("단일 자동차 객체 생성")
    @Test
    void singleCarCreation() {
        RacingCar racingCar = new RacingCar("Car");

        assertThat(racingCar.getPosition()).isZero();
        assertThat(racingCar.getName()).isEqualTo("Car");
        assertThat(racingCar).isExactlyInstanceOf(RacingCar.class);
    }


    @DisplayName("여러 대의 자동차 객체 생성")
    @Test
    void multipleCarCreation() {
        RacingCar racingCar1 = new RacingCar("Car1");
        RacingCar racingCar2 = new RacingCar("Car2");


        assertThat(racingCar1.getPosition()).isZero();
        assertThat(racingCar1.getName()).isEqualTo("Car1");
        assertThat(racingCar1).isExactlyInstanceOf(RacingCar.class);

        assertThat(racingCar2.getPosition()).isZero();
        assertThat(racingCar2.getName()).isEqualTo("Car2");
        assertThat(racingCar2).isExactlyInstanceOf(RacingCar.class);
    }
}
