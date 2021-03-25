package step3.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.utils.GameRule;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    RacingGame createRacingGameObj(String inputName, int attemps) {
        String[] carNames = inputName.split(",");
        GameRule rule = new GameRule(new RandomUtil());
        Cars cars = new Cars(carNames);
        RacingGame race = new RacingGame(attemps, rule, cars);
        return race;
    }

    @Test
    @DisplayName("RacingGame을 통해 자동차 갯수 잘 가져오는지 테스트")
    void getNumberOfCars() {
        // given
        String inputName = "apple,goog,kakao,naver,cpng";
        String[] splited = inputName.split(",");
        int expected = splited.length;
        int attemps = 5;

        // when
        RacingGame race = createRacingGameObj(inputName, attemps);
        int actual = race.getNumberOfCars();

        // then
        assertEquals(actual, expected);
    }
}
