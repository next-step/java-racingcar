package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarGroupTest {
    @Test
    @DisplayName("경주용 자동차 생성")
    public void createRaceCar() {
        CarNames carNames = new CarNames("BMW,KIA,HONDA");
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 개수 2이상 확인")
    public void checkTwoCars(){
        CarNames carNames = new CarNames("BMW,KIA");
        assertThat(carNames.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주용 자동차 이름확인")
    public void checkRaceCarName() {
        CarNames carNames = new CarNames("BMW,KIA,HONDA");
        assertAll(
                () -> assertThat(carNames.carName(0)).isEqualTo("BMW"),
                () -> assertThat(carNames.carName(1)).isEqualTo("KIA"),
                () -> assertThat(carNames.carName(2)).isEqualTo("HONDA")
        );
    }
}
