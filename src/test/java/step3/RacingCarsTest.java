package step3;

import CarRacing.MovingStrategy;
import CarRacing.RacingCars;
import CarRacing.RacingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private RacingCars racingCars;
    private RacingStrategy racingStrategy;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(new String[]{"Jinwoo", "Miller", "John"});
        racingStrategy = new MovingStrategy();
    }

    @DisplayName("차 3대가 잘 만들어졌는지 확인")
    @Test
    void createRacingCarsTest() {
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
    }

    @DisplayName("3회 움직인 후에 화면을 보여준다.")
    @Test
    void displayCarsCurrentStatus() {
        for (int i = 0; i < 3; i++ ){
            racingCars.race(racingStrategy);
        }

        racingCars.showCurrentStatus();
        assertThat(racingCars).isNotNull();
    }
}
