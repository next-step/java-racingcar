package game.controller.dto;

import game.model.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsDtoTest {

    @Test
    void 높은_위치에_위치한_자동차_리스트_조회() {
        CarsDto carsDto = CarsDto.from(new Cars(List.of("a", "b", "c")));

        Assertions.assertThat(carsDto.getLocatedHighPositionCars()).isEqualTo(carsDto.getCarList());
    }

}
