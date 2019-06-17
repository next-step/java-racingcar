package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @Test
    @DisplayName("개수만큼 자동차를 생성한다")
    void carGenerator() {
        int count = 3;

        Cars generate = Cars.generate(count);

        assertThat(generate).isNotNull();
        assertThat(generate.getCars().size()).isEqualTo(3);
    }

    @DisplayName("자동차 생성 개수가 음수일 경우 실패")
    @Test
    void generateFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.generate(-1));
    }

    @Test
    @DisplayName("자동차들이 전진한다")
    void moveCar() {
        Cars cars = Cars.generate(3);
        cars.moveAll(new MovingGenerator());
        assertThat(cars.getCars()).extracting(Car::getPosition).containsOnly(2);
    }

    @Test
    @DisplayName("자동차는 움직이지 않는다")
    void nonMoveCar() {
        Cars cars = Cars.generate(3);
        cars.moveAll(new NoMovingGenerator());
        assertThat(cars.getCars()).extracting(Car::getPosition).containsOnly(1);
    }
}
