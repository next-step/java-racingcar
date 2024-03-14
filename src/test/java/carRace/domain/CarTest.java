package carRace.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("자동차가 전달받는 값이 4보다 큰 경우 동작해야한다.")
    public void Car_Should_Not_Move_If_Input_Greater_Than_Four(int input, boolean expected) throws Exception{
        //given
        Car sutCar = new Car();
        //when
        boolean isMove = sutCar.move(input);
        //then
        assertThat(isMove).isEqualTo(expected);
    }
}
