package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void create_자동차를_생성한다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);

        assertThat(car).isEqualTo(Car.create(startStep, name));
    }

    @Test
    void create_자동차는_게임진행기록을_생성한다() {
        int step = 0;
        String name = "dex";
        int round = 1;

        CarRaceGameHistory history = Car.create(step, name)
                .recordHistory(round);

        assertThat(history).isEqualTo(CarRaceGameHistory.record(round, step, name));
    }

    @Test
    void create_이름이_5자를_초과하는_경우_예외를_발생시킨다() {
        int startStep = 0;
        String name = "soohyun";

        assertThatThrownBy(() -> Car.create(startStep, name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5자 이하로 입력 가능합니다.");
    }

    @Test
    void moveBy_자동차_이동조건에_따라_자동차가_이동한다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);
        car.moveBy(() -> true);

        assertThat(car).isEqualTo(Car.create(startStep + 1, name));
    }

    @Test
    void moveBy_자동차_이동조건을_만족하지_않으면_자동차가_이동하지_않는다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);
        car.moveBy(() -> false);

        assertThat(car).isEqualTo(Car.create(startStep, name));
    }
}

