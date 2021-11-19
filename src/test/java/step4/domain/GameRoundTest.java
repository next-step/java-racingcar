package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundTest {

    GameRound gameRound = new GameRound();

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void decideWinner() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        setGameResult();
        invokeDecideWinner();
        assertThat(gameRound.getWinners().size()).isEqualTo(2);
    }

    private void invokeDecideWinner() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = GameRound.class
                .getDeclaredMethod("decideWinner");
        method.setAccessible(true);
        method.invoke(gameRound);
    }

    private void setGameResult() throws NoSuchFieldException, IllegalAccessException {
        Field gameRoundResult = gameRound.getClass().getDeclaredField("gameRoundResult");
        gameRoundResult.setAccessible(true);
        GameRound.ResultOfCar pobi = new GameRound.ResultOfCar("pobi", 5);
        GameRound.ResultOfCar crong = new GameRound.ResultOfCar("crong", 5);
        GameRound.ResultOfCar honux = new GameRound.ResultOfCar("honux", 3);
        List<GameRound.ResultOfCar> resultList = Arrays.asList(pobi, crong, honux);
        gameRoundResult.set(gameRound, resultList);
    }

}