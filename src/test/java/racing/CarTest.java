package racing;

import org.junit.jupiter.api.Test;
import racing.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.domain.Car.isMove;
import static racing.controller.RacingGame.splitCarName;

public class CarTest {

    @Test
    void 랜덤값이_4이상이면_전진한다() {
        assertThat(isMove(4)).isTrue();
    }

    @Test
    void 랜덤값이_4미만이면_전진하지_못한다() {
        assertThat(isMove(3)).isFalse();
    }

    @Test
    void 랜덤값이_4이상이면_포지션값이_1_증가한다() {
        Car car = new Car("njw");
        car.move(() -> true);

        Car expected = new Car("njw", 1);

        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 랜덤값이_4미만이면_포지션값이_그대로다() {
        Car car = new Car("njw");
        car.move(() -> false);

        Car expected = new Car("njw", 0);

        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 자동차에_이름을_부여할_수_있다() {
        Car car = new Car("njw");
        assertThat(car.getName()).isEqualTo("njw");
    }

    @Test
    void 자동차_이름이_5글자_초과되면_에러가_발생한다() {
        assertThatThrownBy(() -> new Car("njwnjw"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받을_수_있다() {
        String[] carNames = splitCarName("njw,njw2,njw3");
        assertThat(carNames).containsExactly("njw", "njw2", "njw3");
    }
}
