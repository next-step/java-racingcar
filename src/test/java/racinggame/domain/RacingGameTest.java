package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_실패() {
        String trial = "a";

        assertThrows(IllegalArgumentException.class, () -> Validator.isNumber(trial));
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_성공() {
        String trial = "5";

        assertDoesNotThrow(() -> Validator.isNumber(trial));
    }

    @Test
    void RacingCar_리스트를_받아_RacingGame_객체_생성() throws IOException {
        String[] carNames = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.racingCarOf(carNames);
        int trial = 5;

        RacingGame racingGame = new RacingGame(racingCars, 5);

        assertTrue(racingGame.getRacingCars().contains(racingCars.get(0)));
        assertTrue(racingGame.getRacingCars().contains(racingCars.get(1)));
        assertThat(racingGame.getTrial()).isEqualTo(trial);
    }

    @RepeatedTest(value = 1000)
    void getRandomValue_랜덤값을_생성()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        RacingGame racingGame = new RacingGame();
        Method getRandomValue = RacingGame.class.getDeclaredMethod("getRandomValue");
        getRandomValue.setAccessible(true);

        int result = (int) getRandomValue.invoke(racingGame);

        assertTrue(result <= 9);
        assertTrue(result >= 0);
    }
}
