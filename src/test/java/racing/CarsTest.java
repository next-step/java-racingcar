package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void ZERO_이하의_Cars_에러(Integer input) {
        assertThatThrownBy(() -> new Cars(input)
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("Never allows the number of cars to be zero or less");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Cars_초기화_체크(Integer input) {
        Cars cars = new Cars(input);
        assertThat(cars.getCarDTOs()).hasSize(input);
    }

    @Test
    void Cars_한칸이동_테스트() {
        Cars cars = new Cars(3);
        cars.move(new MoveOneSpace());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(1));
    }

    @Test
    void Cars_이동안함_테스트() {
        Cars cars = new Cars(3);
        cars.move(new NonMove());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

}