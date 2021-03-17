package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.service.GameRule;
import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("racing 로그 제대로 출력하는지 테스트")
    void getRacingLog() {
        // given
        String expected = "";

        // when
        Car car = new Car();
        NumberGenerator random = new RandomUtil();
        car.move(new GameRule());

        if (random.getRandom() >= 4) {
            expected = "-";
        }

        // then
        String actual = car.getRacingLog();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("전진여부에 따라 제대로 전진하는지 테스트")
    void move() {
        // given
        String expected = "";
        GameRule rule = new GameRule();
        if (rule.isMovable()) {
            expected = "-";
        }

        // when
        Car car = new Car();
        car.move(rule);

        // then
        String actual = car.getRacingLog();
        assertEquals(actual, expected);
    }
}
