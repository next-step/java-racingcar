package carRace.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import carRace.domain.randomNumber.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("자동차가 전달받는 값이 4보다 큰 경우 동작해야한다.")
    @CsvSource(value = {"2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    public void Car_Should_Not_Move_If_Input_Greater_Than_Four(int input, int expected)
        throws Exception {
        //given
        Car sutCar = new Car(new CarName("namhyeopCar"));

        //when
        sutCar.move(new RandomNumber(input));

        //then
        assertThat(sutCar.getMoveDistance().getMoveDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 자동차 이름이 자동차를 생성할 때 설정되야 한다")
    @CsvSource(value = {"namhyeop,jihwan,nara:3", "momo,mimi,uha,momo:4"}, delimiter = ':')
    public void Input_Car_Name_Should_Be_Set_Car(String input, int expectedSize) {
        //given
        CarNames sutInputNames = new CarNames(input.split(","));

        //when
        //then
        assertThat(sutInputNames.getCarNames().size()).isEqualTo(expectedSize);
        assertThat(sutInputNames.getCarNames().size()).isEqualTo(expectedSize);
    }
}
