package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        Engine engine = new RandomEngine();
        Car car = new Car("pobi", engine);
        assertThat(car.name()).isEqualTo(new Name("pobi"));
    }

    @Test
    void 자동차_생성_예외_테스트() {
        assertThatThrownBy(() -> new Car("pandas", new FixedEngine(true)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_움직임_테스트() {
        //given
        Engine justGoEngine = new FixedEngine(true);
        Engine justStopEngine = new FixedEngine(false);
        Car goingCar = new Car("pobi", justGoEngine);
        Car stoppedCar = new Car("panda", justStopEngine);
        //when
        goingCar.move();
        stoppedCar.move();
        //then
        assertThat(goingCar.position()).isEqualTo(1);
        assertThat(stoppedCar.position()).isEqualTo(0);
    }
}