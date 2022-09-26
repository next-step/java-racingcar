package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest
{
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    @DisplayName("Car객체가 요청 숫자만큼 생성되는지 확인한다.")
    void carConstructTest(int number)
    {
        //when
        Cars cars = new Cars(number, 1);
        //then
        assertThat(cars.stream().count()).isEqualTo(number);
    }
}
