package step4.domain;

import org.junit.jupiter.api.Test;
import step4.service.ForwardStrategy;
import step4.service.NumberGenerator;
import step4.service.RacingCarForward;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 랜덤값이_4이상일경우_전진한다() {
        final Car car = createDefaultCar();
        final ForwardStrategy strategy = new RacingCarForward(new FakeUpperNumberGenerator());

        car.forward(strategy);

        assertThat(car.toPosition().getDistance()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만인경우_멈춰있다() {
        final Car car = createDefaultCar();
        final ForwardStrategy strategy = new RacingCarForward(new FakeLowerNumberGenerator());

        car.forward(strategy);

        assertThat(car.toPosition().getDistance()).isEqualTo(0);
    }

    @Test
    void Position으로_우승_자동차를_판별한다() {
        final Position winner = Position.create();
        final Car car = new Car(winner, Name.from("win"));

        final boolean actual = car.isWinner(winner);

        assertThat(actual).isTrue();
    }

    private Car createDefaultCar() {
        return new Car(Position.create(), Name.from("jh"));
    }

    static class FakeUpperNumberGenerator implements NumberGenerator {
        @Override
        public int random(int bound) {
            return 4;
        }
    }

    static class FakeLowerNumberGenerator implements NumberGenerator {
        @Override
        public int random(int bound) {
            return 3;
        }
    }

}