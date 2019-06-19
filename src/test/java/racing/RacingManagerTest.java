package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.common.ErrorMessage;
import racing.domain.RacingManager;
import racing.vo.GameMakingInfo;

class RacingManagerTest {
    private RacingManager manager;
    
    @BeforeEach
    void setUp() {
        manager = new RacingManager(new GameMakingInfo(TestData.MANY_CAR_NAME, TestData.DEFAULT_TIME));
    }
    
    @Test
    void getWinnersTest() {
        manager.setCars(TestData.GAME_ENDED_CARS);
        String winners = manager.getWinnerNames();
        
        Assertions.assertThat(winners).isEqualTo(TestData.WINNER_NAMES);
    }
    
    @Test
    void getMovingHistoryTest() {
        manager.startGame();
        Assertions.assertThat(manager.getMovingHistory().size()).isEqualTo(TestData.DEFAULT_TIME);
    }
    
    @Test
    void newGameManagerFailTest() {
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> 
            new RacingManager(new GameMakingInfo(null, TestData.DEFAULT_TIME)))
          .withMessage(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> 
            new RacingManager(new GameMakingInfo(TestData.DEFAULT_CAR_NAME, TestData.ZERO_TIME)))
          .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
    }
}
