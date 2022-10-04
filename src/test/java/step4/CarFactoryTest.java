package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    @DisplayName("createCar() 메서드는 입력된 차의 대수만큼의 길이를 가진 Car 리스트를 반환한다")
    void prepare_int_to_array() {
        String[] input = {"suchan", "pob", "jun"};
        List<Car> cars = CarFactory.createCar(input);

        int carCount = cars.size();
        assertThat(carCount).isEqualTo(3);
    }
}