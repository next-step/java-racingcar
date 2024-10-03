package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.situation.GameSituation;
import step5.message.ExceptionMessage;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSituationTest {

    @DisplayName("우승자 선별시 아직 시작도 하지않은 게임이면 예외를 발생시킨다.")
    @Test
    void checkStartTest() {
        GameSituation gameSituation = new GameSituation();

        assertThatThrownBy(gameSituation::checkStart)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.GAME_NOT_START.message());
    }

    @DisplayName("자동차게임이 이전에 이미 시작되었다면 예외를 발생시킨다.")
    @Test
    void alreadyStartTest() {
        GameSituation gameSituation = new GameSituation();
        gameSituation.addCarStrategy(new ArrayList<>());

        assertThatThrownBy(gameSituation::checkRestart)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.GAME_ALREADY_START.message());
    }

}
