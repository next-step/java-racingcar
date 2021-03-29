package step3to5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3to5.controller.RacingGame;
import step3to5.utils.GameRule;
import step3to5.utils.NumberGenerator;
import step3to5.utils.TestNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    @Test
    @DisplayName("Car 객체 제대로 가져오는지 테스트")
    void getCars() {
        // given
        String inputName = "apple,goog,kakao,naver,cpng";
        String[] carNames = inputName.split(",");
        int numberOfCars = carNames.length;

        List<Car> expected = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            expected.add(new Car(carNames[i]));
        }

        // when
        Cars cars = new Cars(carNames);
        List<Car> actual = cars.getCars();

        // then
        assertAll(
                () -> assertThat(actual.get(0)).isEqualToComparingFieldByField(expected.get(0)),
                () -> assertThat(actual.get(1)).isEqualToComparingFieldByField(expected.get(1)),
                () -> assertThat(actual.get(2)).isEqualToComparingFieldByField(expected.get(2)),
                () -> assertThat(actual.get(3)).isEqualToComparingFieldByField(expected.get(3)),
                () -> assertThat(actual.get(4)).isEqualToComparingFieldByField(expected.get(4))
        );
    }

    @ParameterizedTest(name = "전진여부 따라 스코어 제대로 출력하는지 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void move(int number) {
        // given
        String inputName = "uber";
        NumberGenerator numberGenerator = new TestNumberGenerator(number);
        GameRule rule = new GameRule(numberGenerator);

        int expected = 0;
        if (number >= 4) {
            expected = 1;
        }

        // when
        Cars actualCars = new Cars(inputName.split(","));
        actualCars.move(rule);

        // then
        List<Car> cars = actualCars.getCars();
        Car car = cars.get(0);
        assertEquals(expected, car.getScore());
    }

    @Test
    @DisplayName("우승자를 제대로 가져오는지 테스트")
    void winners() {
        // given
        int isMovable = 4;
        NumberGenerator numberGenerator = new TestNumberGenerator(isMovable);
        GameRule rule = new GameRule(numberGenerator);
        String[] names = {"socar", "uber", "tesla"};
        int attemps = 4;

        // when
        Cars cars = new Cars(names);
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        List<String> expected = Arrays.asList(names);
        List<String> actual = cars.winners();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("레이싱 결과중 최고점수를 제대로 가져오는지 테스")
    void highScore() {
        // given
        int isMovable = 4;
        NumberGenerator numberGenerator = new TestNumberGenerator(isMovable);
        GameRule rule = new GameRule(numberGenerator);

        int expected = 5;
        String[] names = {"socar", "uber", "tesla"};

        // when
        Cars cars = new Cars(names);
        RacingGame race = new RacingGame(expected, rule, cars);
        race.startRace();

        int actual = 0;
        for (Car car : cars.getCars()) {
            actual = cars.highScore(car, actual);
        }

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("최고점수를 갖는 자동차만 가져오는지 테스트")
    void getCarsWithHighScore() {
        // given
        int isMovable = 4;
        NumberGenerator numberGenerator = new TestNumberGenerator(isMovable);
        GameRule rule = new GameRule(numberGenerator);

        int attemps = 5;
        String[] names = {"socar", "uber", "tesla"};

        List<String> expected = Arrays.asList(names);

        // when
        Cars cars = new Cars(names);
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        List<String> actual = cars.winners();

        // then
        assertEquals(expected, actual);
    }
}
