package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.CarFactory;
import racinggame.domain.RacingCars;
import racinggame.domain.CarSnapshot;
import racinggame.dto.RaceInputDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 자동차가_조건에따라_생성된다() {
        //given
        RaceInputDTO dto = new RaceInputDTO(1, new String[]{"car1","car2","car3"});

        //when
        RacingCars cars = CarFactory.produce(dto);
        List<CarSnapshot> carSnapshots = cars.makeSnapshot();

        //then
        assertThat(carSnapshots).hasSize(3);
        assertThat(carSnapshots.get(0).name()).isEqualTo("car1");
        assertThat(carSnapshots.get(1).name()).isEqualTo("car2");
        assertThat(carSnapshots.get(2).name()).isEqualTo("car3");
    }
}