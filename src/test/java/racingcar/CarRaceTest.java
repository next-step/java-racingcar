package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("car List size 확인")
    void init(){
        CarRace carRace = new CarRace(5);
        assertThat(carRace.getCars()).hasSize(5);
    }
}