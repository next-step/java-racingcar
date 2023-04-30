package racing.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racing.domain.move.MoveOneSpace;
import racing.domain.move.NonMove;

class CarsTest {

    @Test
    void Cars_한칸이동_테스트() {
        Cars cars = new Cars(List.of("a"));
        cars.move(new MoveOneSpace());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(1));
    }

    @Test
    void Cars_이동안함_테스트() {
        Cars cars = new Cars(List.of("a"));
        cars.move(new NonMove());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

}