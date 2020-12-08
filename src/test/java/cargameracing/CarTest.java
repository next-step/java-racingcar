package cargameracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * UnitTest
 * @author minji
 */
public class CarTest {

    @Test
    @DisplayName("차의 개수 확인")
    void inputGameInfo() {
        CarRacingGame racingGame = new CarRacingGame(3);
        assertThat(racingGame.cars.length).isEqualTo(3);
        assertThat(racingGame.getCars().length).isEqualTo(3);
    }
}
