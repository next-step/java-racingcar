package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarGroupTest {
    @Test
    @DisplayName("경주용 자동차 생성")
    public void createRaceCar() {
        CarGroup carGroup = new CarGroup("BMW,KIA,HONDA");
        assertThat(carGroup.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 개수 2이상 확인")
    public void checkTwoCars(){
        CarGroup carGroup = new CarGroup("BMW,KIA");
        assertThat(carGroup.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주용 자동차 이름확인")
    public void checkRaceCarName() {
        CarGroup carGroup = new CarGroup("BMW,KIA,HONDA");
        assertAll(
                () -> assertThat(carGroup.findCarName(0)).isEqualTo("BMW"),
                () -> assertThat(carGroup.findCarName(1)).isEqualTo("KIA"),
                () -> assertThat(carGroup.findCarName(2)).isEqualTo("HONDA")
        );
    }
}
