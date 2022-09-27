package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.CarFactory;
import racinggame.dto.RaceInputDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 자동차가_조건에따라_생성된다() {
        //given
        RaceInputDTO dto = new RaceInputDTO(1, new String[]{"car1","car3","car2"});

        //when
        List<Car> cars = CarFactory.produce(dto);

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).name()).isEqualTo("car1");
    }
}