package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 쉼표로_구분된_이름_개수만큼_자동차가_생성된다() {
        Cars cars = Cars.fromNames(List.of("pobi", "crong", "honux"));

        assertThat(cars.getCars()).hasSize(3);
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