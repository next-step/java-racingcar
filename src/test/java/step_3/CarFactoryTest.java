package step_3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 자동차가_조건에따라_생성된다() {
        //given
        int toProduceCarCount = 3;

        //when
        List<Car> cars = CarFactory.produce(toProduceCarCount);

        //then
        assertThat(cars).hasSize(3);
    }
}