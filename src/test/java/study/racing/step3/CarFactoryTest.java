package study.racing.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 6})
    @DisplayName("CreateCar는 해당하는 숫자만큼 차량을 생성한다.")
    void isCreateCars_ShouldReturnCarsAccordingToCount(int count) {
        //given
        List<Car> cars = new ArrayList<>();

        //when
        cars = CarFactory.createCars(count);

        //then
        assertThat(cars).hasSize(count);
    }

}
