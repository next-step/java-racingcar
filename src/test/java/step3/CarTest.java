package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Score;
import step3.service.GameRule;
import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @ParameterizedTest(name = "전진여부 따라 스코어 제대로 출력하는지 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getScore(int number) {
        // given
        NumberGenerator numberGenerator = new RandomUtil();
        GameRule rule = new GameRule(numberGenerator);
        String scoreSymbol = "-";
        Car car = new Car(scoreSymbol);

        Score expected = new Score("-");
        if (rule.isMovableTest(number)) {
            expected.setScore();
        }

        // when
        car.moveTest(rule, number);
        Score actual = car.getScore();

        // then
        assertEquals(actual, expected);
    }
}
