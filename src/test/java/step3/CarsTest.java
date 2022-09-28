package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertThat(cars.getCarList()).hasSize(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test1,test2", "test1,test2,test3", "test1,test2,test3,test4"})
    @DisplayName("Car객체가 카이름의 개수 만큼 생성되는지 확인한다.")
    void carConstructTest(String str)
    {
        //given
        String[] carNames = str.split(",");
        //when
        Cars cars = new Cars(carNames, new RandomMovingStrategy());
        //then
        assertThat(cars.getCarList()).hasSize(carNames.length);
    }
}
