package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.CarFactory;
import racinggame.domain.RacingCars;
import racinggame.dto.RaceInputDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 자동차가_조건에따라_생성된다() {
        //given
        RaceInputDTO dto = new RaceInputDTO(1, new String[]{"car1","car2","car3"});

        //when
        RacingCars racingCars = CarFactory.produce(dto);
        List<Car> cars = racingCars.getCars();

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).name()).isEqualTo("car1");
        assertThat(cars.get(1).name()).isEqualTo("car2");
        assertThat(cars.get(2).name()).isEqualTo("car3");
    }
}