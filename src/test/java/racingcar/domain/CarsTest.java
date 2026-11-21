package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 쉼표로_구분된_이름_개수만큼_자동차가_생성된다() {
        Cars cars = new Cars("pobi,honux,crong");
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 이름_앞뒤_공백은_제거하고_수용한다() {
        Cars cars = new Cars("pobi, crong");

        assertThat(cars.getCars()).extracting(car -> car.getName().getValue())
                .containsExactly("pobi", "crong");
    }

    @Test
    void 이름이_비어있으면_예외를_던진다() {
        assertThatThrownBy(() -> new Cars("pobi, ,crong"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가장_멀리_이동한_자동차가_우승자가_된다() {

        Cars cars = new Cars(List.of(new Car("pobi", 4), new Car("honux", 3)));

        List<Car> winners = cars.findWinners();

        assertThat(winners).extracting(car -> car.getName().getValue())
                .containsExactly("pobi");
    }

    @Test
    void 최대_이동_거리가_같은_자동차가_여러_대면_모두_우승자가_된다() {
        Cars cars = new Cars(List.of(new Car("pobi", 4), new Car("honux", 4), new Car("crong", 3)));

        List<Car> winners = cars.findWinners();

        assertThat(winners).extracting(car -> car.getName().getValue())
                .containsExactly("pobi", "honux");
    }

}