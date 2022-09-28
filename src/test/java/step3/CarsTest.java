package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Cars;
import step3.model.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest
{
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    @DisplayName("Car객체가 요청 숫자만큼 생성되는지 확인한다.")
    void carConstructTest(int number)
    {
        //when
        Cars cars = new Cars(number, new RandomMovingStrategy());
        //then
        assertThat(cars.getCarList().size()).isEqualTo(number);
    }
}
