package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 가장 멀리 간 차들의 이름을 반환한다.")
    void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 4),
                new Car("chan", 6),
                new Car("tommy", 6)));

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames).containsAnyOf("tommy", "chan");
    }

    @Test
    @DisplayName("자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리")
    void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 4),
                new Car("chan", 5),
                new Car("tommy", 6)));

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames).containsAnyOf("tommy");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 예외가 발생합니다.")
    void 자동차_이름에_중복이_있으면_예외가_발생합니다() {
        assertThatThrownBy(() -> new Cars(
                List.of(new Car("pobi"),
                        new Car("ipt"),
                        new Car("ipt"))))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("자동차 이름에 중복이 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 없고 모두 5글자 이하라면 정상적으로 생성합니다")
    void 자동차_이름에_중복이_없고_모두_5글자_이하라면_정상적으로_생성합니다() {
        assertThatCode(() -> new Cars(
                List.of(new Car("pobi"),
                        new Car("ipt"),
                        new Car("neo"))))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("값이 4이상인 경우 자동차를 전진한다.")
    void 값이_4_이상인_경우_자동차를_전진한다() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 3),
                new Car("DD", 4)));

        cars.takeTurn(() -> 5);

        assertThat(cars.getCars()).containsAll(List.of(
                new Car("ipt", 4),
                new Car("DD", 5)));
    }

    @Test
    @DisplayName("값이 3이하인 경우 자동차가 멈춘다")
    void 값이_3_이하인_경우_자동차_멈춘다() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 3),
                new Car("DD", 4)));

        cars.takeTurn(() -> 2);

        assertThat(cars.getCars()).containsAll(List.of(
                new Car("ipt", 3),
                new Car("DD", 4)));
    }

    @Test
    @DisplayName("Cars 객체를 복사한 Cars 객체는 서로 다르다.")
    void Cars_객체를_복사한_Cars_객체는_서로_다르다() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 3),
                new Car("DD", 4)));

        Cars copy = cars.copy();

        Assertions.assertThat(cars).isNotEqualTo(copy);
    }

    @Test
    @DisplayName("Cars 객체를 복사한 Cars 객체는 연산할 수 없다.")
    void Cars_객체를_복사한_Cars_객체는_연산할_수_없다() {
        Cars cars = new Cars(List.of(
                new Car("ipt", 3),
                new Car("DD", 4)));

        Cars copy = cars.copy();

        assertThatCode(() -> copy.getCars().add(new Car("dssa")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
