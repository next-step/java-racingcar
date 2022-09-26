package racinggame.core.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.InvalidCarIndexException;

class CarsTest {

    @Test
    @DisplayName("차량 수 반환.")
    void get_cars_size() {
        Cars cars = getDefaultCars();

        assertThat(cars.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("해당 인덱스의 차량 이름 반환.")
    @CsvSource(value = {"0:phobi", "1:crong", "2:honux"}, delimiter = ':')
    void get_cars(int index, String expected) {
        Cars cars = getDefaultCars();

        assertThat(cars.getCar(index)
                .getName()
        ).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("차량 수 범위를 넘어가는 인덱스로 차량 조회 시 예외 발생.")
    @ValueSource(ints = {-1, 3})
    void fail_to_get_by_wrong_index(int index) {
        Cars cars = getDefaultCars();

        assertThatThrownBy(() -> cars.getCar(index))
                .isInstanceOf(InvalidCarIndexException.class);
    }

    private Cars getDefaultCars() {
        return new Cars(
                List.of(
                        new Car("phobi"),
                        new Car("crong"),
                        new Car("honux")
                )
        );
    }
}