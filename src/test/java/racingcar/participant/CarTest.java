package racingcar.participant;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차는_이름을_기준으로_중복된_객체를_제거한다() {
        Set<Car> cars = new HashSet<>(List.of(new Car(new CarName("a")), new Car(new CarName("a")), new Car(new CarName("b"))));
        assertThat(cars).hasSize(2);
    }

    @Test
    void 자동차는_몇번_플레이_했는지_확인할_수_있다() {
        Car car = new Car(new CarName("test"));
        assertThat(car.play()).isGreaterThanOrEqualTo(0);
        assertThat(car.getPlayCount()).isEqualTo(1);
    }

    @Test
    void 자동차의_전진한_거리가_0_또는_양수의_숫자로_리턴된다() {
        Car car = new Car(new CarName("test"));
        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
    }
}