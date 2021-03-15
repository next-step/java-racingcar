package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.utils.RandomGenerator;
import step3.utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("racing 로그 제대로 출력하는지 테스트")
    void getRacingLog() {
        // given
        String expected = "-";

        // when
        Car car = new Car();
        RandomGenerator random = new RandomUtil();
        car.move(random);

        if (random.getRandom() >= 4) {
            expected = "--";
        }

        // then
        String actual = car.getRacingLog();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전진여부에 따라 제대로 전진하는지 테스트")
    void move() {
        // given
        String expected = "-";
        RandomGenerator random = new RandomUtil();
        Car car = new Car();

        // when
        car.move(random);

        if (car.isMoving(random)) {
            expected = "--";
        }

        // then
        String actual = car.getRacingLog();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("랜덤 값에 따라 전진여부 제대로 결정되는지 테스트")
    void isMoving() {
        // given
        RandomGenerator random = new RandomUtil();
        Car car = new Car();
        boolean expected = random.getRandom() >= 4;

        // when
        boolean actual = car.isMoving(random);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}
