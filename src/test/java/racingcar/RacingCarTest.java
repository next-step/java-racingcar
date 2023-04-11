package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @DisplayName("0에서 9사이의 random 값을 구한다.")
    @Test
    void getRandomNumber() {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        int randomNumber = racingCar.getRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @DisplayName("random 값이 4이상이면 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:false","1:false","2:false","3:false",
                        "4:true","5:true","6:true","7:true","8:true","9:true"}, delimiter = ':')
    void move(int randomNumber, boolean result) {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        boolean moveYn = racingCar.move(randomNumber);

        //then
        assertThat(moveYn).isEqualTo(result);
    }

    @DisplayName("자동차의 상태 만들기(1회 전진마다 -추가")
    @ParameterizedTest
    @CsvSource(value = {"0:''","1:'-'","2:'--'","3:'---'","4:'----'","5:'-----'"}, delimiter = ':')
    void makeCarMoveStateLine(int moveCount, String result) {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        String line = racingCar.makeCarMoveStateLine(moveCount);

        //then
        assertThat(line).isEqualTo(result);
    }
}
