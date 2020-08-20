package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RacingGameTest {


    @Test
    void createCarsTest() {
        assertThat(RacingGame.createCars(5).size()).isEqualTo(5);
    }



}
