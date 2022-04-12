package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp(){
        cars = new Cars(3);
    }

    @DisplayName("n대의 자동차 생성자 테스트")
    @Test
    void cars_unit_test(){
        assertThat(cars.getCars().size()).isEqualTo(3);
    }


}