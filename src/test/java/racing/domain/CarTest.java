package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("이름을 입력하면 해당 이름이 반환된다.")
    @CsvSource(value = {"car1", "car2", "car3"})
    public void returnCarName(String value) {
        Car car = new Car(value);
        String playerName = car.printCarName();

        assertThat(playerName).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("결과값의 따라 자동차가 움직인다.")
    @CsvSource(value = {"true,1,", "false,0", "true,1"})
    public void carRacingConditionCheck(boolean moveFlag, int position) {
        Car car = new Car("car1");

        car.move(moveFlag);
        assertThat(car.printPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @DisplayName("이름이 5글자 이상이면 예외처리가 발생된다.")
    @CsvSource(value = {"smith", "tester", "freeze"})
    public void nameLengthCheck(String value) {
        assertThrows(IllegalArgumentException.class, () ->
            new Name(value)
        );
    }

    @ParameterizedTest
    @DisplayName("경주시 움직인 값과 결과값이 동일하다.")
    @CsvSource(value = {"car1,true,1,false,1", "car2,false,0,true,1", "car3,false,0,false,0"})
    public void returnCarResultRacing(String value, boolean race1, int raceResult1, boolean race2, int raceResult2) {
        Car car = new Car(value);
        car.move(race1);

        assertThat(car.printPosition()).isEqualTo(raceResult1);

        car.move(race2);

        assertThat(car.printPosition()).isEqualTo(raceResult2);
    }

    @Test
    @DisplayName("경주에서 최고값이 해당 위치와 일치하면 true 그렇지 않으면 false 를 반환한다.")
    public void isWinnerCheck(){
        int maxPosition = 3;
        Car car = new Car("car");
        car.move(true);
        car.move(true);

        assertThat(car.isWinner(maxPosition)).isFalse();

        car.move(true);
        assertThat(car.isWinner(maxPosition)).isTrue();
    }

}