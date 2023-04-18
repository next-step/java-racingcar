package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void Cars_Empty_Input_에러(String input) {
        assertThatThrownBy(() -> new Cars(input)
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("Never allows empty input");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,crong:2", "pobi,crong,honux:3"},delimiter = ':')
    void Cars_초기화_체크(String input, Integer size) {
        Cars cars = new Cars(input);
        assertThat(cars.getCarDTOs()).hasSize(size);
    }

    @Test
    void Cars_5글자_초과_에러() {
        assertThatThrownBy(() -> new Cars("abcdef")
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("Car names cannot be more than 5 characters long.");
    }

    @Test
    void Cars_한칸이동_테스트() {
        Cars cars = new Cars("a");
        cars.move(new MoveOneSpace());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(1));
    }

    @Test
    void Cars_이동안함_테스트() {
        Cars cars = new Cars("a");
        cars.move(new NonMove());
        cars.getCarDTOs().forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

}