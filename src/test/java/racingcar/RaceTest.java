package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    @DisplayName("레이싱게임 전과정 테스트: 자동차 3개, 라운드 5번")
    void testRaceGameEntireProcess() {
        Race race = new Race(3, 5, new RandomStrategy(new RandomNumber()));
        race.doRace();
        ResultView.printResult(race.getCarsPositionPerRound());
    }

}
