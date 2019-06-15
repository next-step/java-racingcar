package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame; 
    
    @BeforeEach
    void setUp() {
        this.racingGame = new RacingGame();
    }
    
    @Test
    void setTimeExceptionTest() {
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> racingGame.setTime(101))
          .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
        
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> racingGame.setTime(0))
          .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
    }
    
    @Test
    void setCarsExceptionTest() { 
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> racingGame.makeCars(101))
          .withMessage(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
    
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> racingGame.makeCars(0))
          .withMessage(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
    
    }
    
    @Test
    void getTimeTest() {
        int testTimeCount = 5;
        racingGame.setTime(testTimeCount);
        Assertions.assertThat(racingGame.getTime()).isEqualTo(testTimeCount);
    }
    
    @Test
    void getCarsTest() {
        int testCarsCount = 5;
        racingGame.makeCars(testCarsCount);
        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(testCarsCount);
    }
}
