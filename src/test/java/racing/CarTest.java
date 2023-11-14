package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.Car.*;
import static racing.RacingGame.splitCarName;
import static racing.RacingGame.winner;

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

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다() {
        List<Car> cars = List.of(new Car("A", 3), new Car("B", 2), new Car("C", 1));
        String winner = winner(cars);
        assertThat(winner).isEqualTo("A");
    }

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다_여러명() {
        List<Car> cars = List.of(new Car("Q", 5), new Car("W", 2), new Car("E", 5));
        String winner = winner(cars);
        assertThat(winner).isEqualTo("Q,E");
    }

}
