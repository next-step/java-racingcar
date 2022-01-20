package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void RacingCar_리스트를_받아_RacingGame_객체_생성() {
        String[] carNames = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(carNames);
        int trial = 5;

        RacingGame racingGame = new RacingGame(racingCars, 5);

        assertTrue(racingGame.getRacingCars().contains(racingCars.get(0)));
        assertTrue(racingGame.getRacingCars().contains(racingCars.get(1)));
        assertThat(racingGame.getTrial()).isEqualTo(trial);
    }

    @Test
    void canForward_전진실패()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int randomValue = 1;

        RacingGame racingGame = new RacingGame();
        Method canForward = RacingGame.class.getDeclaredMethod("canForward", int.class);
        canForward.setAccessible(true);
        boolean result = (boolean) canForward.invoke(racingGame, randomValue);

        assertFalse(result);
    }

    @Test
    void canForward_전진가능()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        int randomValue = 5;

        RacingGame racingGame = new RacingGame();
        Method canForward = RacingGame.class.getDeclaredMethod("canForward", int.class);
        canForward.setAccessible(true);
        boolean result = (boolean) canForward.invoke(racingGame, randomValue);

        assertTrue(result);
    }
}