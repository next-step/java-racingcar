package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName(value = "참가할 자동차 목록을 최초 생성한다.")
    @Test
    void 최초_자동차_목록_생성() {
        // given
        String[] names = {"jason", "park", "david"};

        // when
        Cars cars = new Cars(names);


        // then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCarList()).containsExactly(new Car("jason"), new Car("park"), new Car("david"));
    }

    @DisplayName(value = "참가할 자동차 목록을 최초 이후로 생성하면 이전 객체를 가진 새로운 객체를 사용한다.")
    @Test
    void 최초_이후_자동차_목록_생성() {
        // given
        String[] names = {"jason", "park", "david"};

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.getCarList()).containsExactly(new Car("jason"), new Car("park"), new Car("david"));
    }
}