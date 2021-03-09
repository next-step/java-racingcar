package racingcar;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Rule;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

  @ParameterizedTest
  @CsvSource({
      "5, 3",
      "10, 1",
      "1, 2",
      "1, 10"
  })
  @DisplayName("유저에게 입력받은 값을 토대로 규칙을 생성할 수 있는가")
  public void createCarsByUserInput(int numberOfCar, int numberOfRound)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    //given
    RacingGame racingGame = new RacingGame();

    //when
    Method method = racingGame.getClass().getDeclaredMethod("initPhase", int.class, int.class);
    method.setAccessible(true);

    Field field = racingGame.getClass().getDeclaredField("rule");
    field.setAccessible(true);

    method.invoke(racingGame, numberOfCar, numberOfRound);

    //then
    Rule rule = (Rule) field.get(racingGame);

    assertAll(
        () -> assertEquals(rule.getCars().getCars().size(), numberOfCar),
        () -> assertEquals(rule.getRound(), numberOfRound)
    );
  }

}