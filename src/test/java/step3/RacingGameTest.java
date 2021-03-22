package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.RacingGame;
import step3.domain.Cars;
import step3.service.GameRule;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    RacingGame createRacingGameObj(int numberOfCars, int attemps) {
        GameRule rule = new GameRule(new RandomUtil());
        String scoreSymbol = "-";
        Cars cars = new Cars(numberOfCars, scoreSymbol);
        RacingGame race = new RacingGame(numberOfCars, attemps, rule, cars);
        return race;
    }

    @Test
    @DisplayName("RacingGame을 통해 자동차 갯수 잘 가져오는지 테스트")
    void getNumberOfCars() {
        // given
        int expected = 4;
        int attemps = 5;

        // when
        RacingGame race = createRacingGameObj(expected, attemps);
        int actual = race.getNumberOfCars();

        // then
        assertEquals(actual, expected);
    }
}
