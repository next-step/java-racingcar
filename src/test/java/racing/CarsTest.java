package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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