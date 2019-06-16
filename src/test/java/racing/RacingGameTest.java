package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.common.ErrorMessage;

class RacingGameTest {
    private final static String CAR_NAMES = "a,b,c,d";
    private final static String COMMA = ",";
    private final int OVER_CARS_COUNT = RacingGame.MAX_CARS + 1;
    private final int OVER_TIME_COUNT = RacingGame.MAX_TIME + 1;
    private final int SUCCESS_CARS_COUNT = RacingGame.MIN_CARS;
    private final int SUCCESS_TIME_COUNT = RacingGame.MIN_TIME;
    private final int SHORT_CARS_COUNT = 0;
    private final int SHORT_TIME_COUNT = 0;
    
//    @Test
//    void overMaxValueTest() {
//        Assertions.assertThatIllegalArgumentException()
//          .isThrownBy(() -> new RacingGame(SUCCESS_CARS_COUNT, OVER_TIME_COUNT))
//          .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
//        
//        Assertions.assertThatIllegalArgumentException()
//          .isThrownBy(() -> new RacingGame(OVER_CARS_COUNT, SUCCESS_TIME_COUNT))
//          .withMessage(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
//    
//    }
//    
//    @Test
//    void shortValueTest() { 
//        Assertions.assertThatIllegalArgumentException()
//          .isThrownBy(() -> new RacingGame(SUCCESS_CARS_COUNT, SHORT_TIME_COUNT))
//          .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
//
//        Assertions.assertThatIllegalArgumentException()
//          .isThrownBy(() -> new RacingGame(SHORT_CARS_COUNT, SHORT_TIME_COUNT))
//          .withMessage(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
//    
//    }
//    
//    @Test
//    void getterTest() {
//        RacingGame racingGame = new RacingGame(SUCCESS_CARS_COUNT, SUCCESS_TIME_COUNT);
//        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(SUCCESS_CARS_COUNT);
//        Assertions.assertThat(racingGame.getTime()).isEqualTo(SUCCESS_TIME_COUNT);
//    }

    @Test
    void makeCarTest() {
        int expectedSize = CAR_NAMES.split(",").length;
        RacingGame racingGame = new RacingGame(CAR_NAMES, SUCCESS_TIME_COUNT);
        Assertions.assertThat(racingGame.getCars().size())
          .isEqualTo(expectedSize);
    }
    
    @Test
    void isMovableTest() {
        int movableNumber = 4;
        int notEnoughNumber = 3;
        Assertions.assertThat(RacingGame.isMovable(movableNumber)).isTrue();
        Assertions.assertThat(RacingGame.isMovable(notEnoughNumber)).isFalse();
    }
    
//    @Test
//    void starGameTest() {
//        RacingGame racingGame = new RacingGame(RacingGame.MAX_CARS, RacingGame.MAX_TIME);
//        racingGame.startRacing();
//        boolean noCarMoved = racingGame.getCars().stream()
//          .allMatch(car -> car.getPosition() == 0);
//        Assertions.assertThat(noCarMoved).isFalse();
//    }
}
