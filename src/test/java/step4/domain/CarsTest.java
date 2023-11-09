package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("사용자에게 입력받은 이름의 개수만큼 자동차를 생성한다.")
    @Test
    void createCarsWithName() {
        // given
        String[] nameOfCars = {"hong","kim","lee"};

        // when
        Cars cars = new Cars(nameOfCars);

        // then
        assertThat(cars.getNumOfCars()).isEqualTo(3);
    }

    @DisplayName("인자로 인덱스를 받아 해당 인덱스의 Car객체를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    void getCarBy(int idx) {
        // given
        String[] nameOfCars = {"hong","kim","lee"};
        Cars cars = new Cars(nameOfCars);

        // when
        Car car = cars.findCarBy(idx);

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("인자로 인덱스를 받아 해당 인덱스의 Car객체를 반환할 때 인덱스의 범위가 벗어나면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void getCarByWhenOufOfIndex(int idx) {
        // given
        String[] nameOfCars = {"hong","kim","lee"};
        Cars cars = new Cars(nameOfCars);

        // when & then
        assertThatThrownBy(() -> cars.findCarBy(idx)).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("해당 번호의 차량은 존재하지 않습니다.");
    }
}