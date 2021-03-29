package step3to5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3to5.controller.RacingGame;
import step3to5.utils.GameRule;
import step3to5.utils.NumberGenerator;
import step3to5.utils.TestNumberGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CarTest {

    @Test
    @DisplayName("자동차 이름 가져오는지 테스트")
    void getName() {
        // given
        String given = "socar,uber,kakao,goog,gm,benz";
        String[] expected = given.split(",");

        // when
        Cars cars = new Cars(expected);
        String[] actual = new String[expected.length];
        List<Car> list = cars.getCars();
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            actual[i] = car.getName();
        }

        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차별 스코어 연산 테스트")
    void getScore() {
        // given
        String given = "socar,uber,kakao,goog,gm,benz";
        String[] names = given.split(",");
        Cars cars = new Cars(names);

        int testNum = 4;
        NumberGenerator numberGenerator = new TestNumberGenerator(testNum);

        GameRule rule = new GameRule(numberGenerator);
        int attemps = 5;

        int[] expected = {5, 5, 5, 5, 5, 5};

        // when
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        int[] actual = new int[names.length];
        List<Car> list = cars.getCars();

        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            actual[i] = car.getScore();
        }

        // then
        assertArrayEquals(expected, actual);
    }
}
