package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("사용자에게 입력받은 수만큼 자동차를 생성한다.")
    @Test
    void createCars() {
        // given
        int numOfCars = 5;

        // when
        Cars cars = new Cars(numOfCars);
        int result = cars.getNumOfCars();

        // then
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("인자로 인덱스를 받아 해당 인덱스의 Car객체를 반환한다.")
    @Test
    void getCarBy() {
        // given
        Cars cars = new Cars();

        // when


        // then

    }
}