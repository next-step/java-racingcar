package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.common.Cars;
import racing.common.RacingManager;

public class RacingManagerTest {
    @Test
    void moveCarTest() {
        RacingManager manager = new RacingManager("11,22,33,44,55,66,77");
        manager.moveCars();
        Assertions.assertThat(manager.getCars().getCars().stream()
            .allMatch(car -> car.getPosition() == 0)).isFalse();
    }
    
    @Test
    void getWinnersTest() {
        RacingManager manager = new RacingManager(TestData.GAME_ENDED_CARS);
        Cars winners = manager.getWinners();
        
        Assertions.assertThat(
          winners.getCars().stream()
            .allMatch(car -> TestData.WINNER_NAMES.contains(car.getName()))
        ).isTrue();
    }
}
