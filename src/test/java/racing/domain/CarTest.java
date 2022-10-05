package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차에_이름을_부여한다() {
        Car car = new Car(new AlwaysMovingRule(), "씽씽이");
        assertThat(car.getName()).isEqualTo("씽씽이");
    }

    @Test
    void 자동차의_이름이_5자를_초과하면_에러발생() {
        assertThatThrownBy(() -> new Car(new AlwaysMovingRule(), "뛰뛰빵빵씽씽이"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차의 이름은 5자를 초과할수 없습니다.");
    }

    @Test
    void 자동차를_무작위로_이동_시킨다() {
        Car car = new Car(new RandomRule(), "씽씽이");
        car.move();
        assertThat(car.compare(car, new Car(new RandomRule(), "쌩썡이"))).isIn(1, 0);
    }

    @Test
    void 자동차가_무조건_이동() {
        Car car = new Car(new AlwaysMovingRule(), "씽씽이");
        car.move();
        assertThat(car.compare(car, new Car(new AlwaysMovingRule(), "쌩썡이"))).isEqualTo(1);
    }
}