package step3to5.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3to5.domain.Cars;
import step3to5.utils.GameRule;
import step3to5.utils.RandomUtil;
import step3to5.utils.TestNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("레이스 테스트")
    void startRace() {
        // given
        int attemps = 10;
        String given = "socar,uber,tesla,benz,bmw";

        String[] carNames = given.split(",");
        GameRule rule = new GameRule(new RandomUtil());

        // when
        Cars cars = new Cars(carNames);
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        List<String> expected = Arrays.asList(carNames);
        List<String> actual = cars.winners();

        // then
        assertThat(actual).isNotSameAs(expected);
    }

    @Test
    @DisplayName("우승자 가져오는 테스트")
    void getChampion() {
        // given
        int attemps = 10;
        String given = "socar,uber,tesla,benz,bmw";
        String[] carNames = given.split(",");
        int isMovable = 4;
        GameRule rule = new GameRule(new TestNumberGenerator(isMovable));

        // when
        Cars cars = new Cars(carNames);
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        List<String> actual = race.getChampion();
        List<String> expected = Arrays.asList(carNames);

        // then
        assertEquals(expected, actual);
    }
}
