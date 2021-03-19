package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.RacingGame;
import step3.domain.Car;
import step3.domain.Cars;
import step3.service.GameRule;
import step3.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    @DisplayName("자동차 List 조회 테스트")
    void getCars() {
        // given
        int numberOfCars = 4;
        int attemps = 5;
        String scoreSymbol = "-";

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            list.add(new Car(scoreSymbol));
        }
        int expected = list.size();

        // when
        int actual = createRacingGameObj(numberOfCars, attemps).getCars().size();

        // then
        assertEquals(actual, expected);
    }

    @Test
    void doRace() {

    }

    @Test
    void raceByRound() {
        // given


        // when

        // then

    }
}
