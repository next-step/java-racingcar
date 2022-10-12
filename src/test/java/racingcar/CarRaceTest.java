package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.RandomMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("car List size 확인")
    void init(){
        CarRace carRace = new CarRace(5, new RandomMovableStrategy());
        assertThat(carRace.getCars()).hasSize(5);
    }
}