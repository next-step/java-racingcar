package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.util.CarFactory;

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