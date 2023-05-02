package domain.cars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.cars.RacingCar;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("차는 전진한다.")
    @Test
    public void shouldGoOneStep() throws Exception {
        //when
        racingCar.moveOrStop(() -> true);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @DisplayName("차는 전진하지 않는다.")
    @Test
    public void shouldStop() throws Exception {
        //when
        racingCar.moveOrStop(() -> false);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }



}

