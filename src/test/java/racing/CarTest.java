package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("입력받은 숫자가 4이상이면 증가하고 그렇지 않으면 정지한다.")
    @CsvSource(value = {"4,1","3,0","7,1"})
    public void carRacingConditionCheck(int randomValue, int moveValue) {
        Car car = new Car("car1");
        int result = car.carMove(randomValue);

        assertThat(result).isEqualTo(moveValue);
    }

    @ParameterizedTest
    @DisplayName("이름을 입력하면 해당 이름이 반환된다.")
    @CsvSource(value = {"car1","car2","car3"})
    public void returnCarName(String value){
        Car car = new Car(value);
        String playerName = car.getCarName();

        assertThat(playerName).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("이름이 5글자 이상이면 예외처리가 발생된다.")
    @CsvSource(value = {"smith","tester","freeze"})
    public void nameLengthCheck(String value){
        assertThatThrownBy(() -> new Car(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("경주시 움직인 값과 결과값이 동일하다.")
    @CsvSource(value = {"car1,1,5,7","car2,2,4,8","car3,0,9,1"})
    public void returnCarResultRacing(String value,int race1, int race2, int race3){
        Car car = new Car(value);
        int result1 = car.carMove(race1);

        assertThat(result1).isEqualTo(car.resultRacing());

        int result2 = car.carMove(race2);

        assertThat(result2).isEqualTo(car.resultRacing());

        int result3 = car.carMove(race3);

        assertThat(result3).isEqualTo(car.resultRacing());
    }

}