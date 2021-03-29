package step3to5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3to5.controller.RacingGame;
import step3to5.utils.GameRule;
import step3to5.utils.TestNumberGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultDtoTest {

    @Test
    @DisplayName("자동차수 가져오는 테스트")
    void getNumberOfCars() {
        // given
        String given = "socar,uber,kakao,goog,gm,benz";
        String[] names = given.split(",");

        // when
        Cars cars = new Cars(names);
        ResultDto resultDto = new ResultDto(cars);

        // then
        int expected = names.length;
        int actual = resultDto.getNumberOfCars();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 레이싱때 출력 테스트")
    void printResultByCar() {
        // given
        int iterator = 1;
        String[] names = {"uber", "socar"};
        Cars cars = new Cars(names);

        int isMovable = 4;
        int attemps = 3;
        GameRule rule = new GameRule(new TestNumberGenerator(isMovable));
        RacingGame race = new RacingGame(attemps, rule, cars);
        race.startRace();

        List<Car> list = cars.getCars();
        Car car = list.get(iterator);

        // when
        ResultDto resultDto = new ResultDto(cars);
        String actual = resultDto.printResultByCar(iterator);

        String score = resultDto.convertStringFromScoreNumber(car.getScore());
        String expected = car.getName() + " : " + score;

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("스코어를 심볼로 변환하는 테스트")
    void convertStringFromScoreNumber() {
        // given
        int score = 5;
        String expected = "-----";

        String[] names = {"socar"};
        Cars cars = new Cars(names);

        // when
        ResultDto resultDto = new ResultDto(cars);
        String actual = resultDto.convertStringFromScoreNumber(score);

        // then
        assertEquals(expected, actual);
    }
}
