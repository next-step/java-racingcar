package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static study.RacingGame.makeCarList;

public class RacingGameTest {


    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        assertThat(makeCarList(5)).hasSize(5);
    }


    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(int number){
        Car car = new Car();
        car.move(number);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("4미만의 숫자가 들어오면 정지")
    void carStop(int number){
        Car car = new Car();
        car.move(number);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("인풋값에 음수가 들어오면 에러발생")
    void negativeChk(){
            assertThatThrownBy(() -> {new InputNumber(-1);})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수가 들어왔습니다");
    }

    @Test
    @DisplayName("랜덤값에 음수가 들어오면 에러발생")
    void randomNegativeChk(){
        assertThatThrownBy(() -> {new RandomNumber(-1);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 들어왔습니다");
    }

    @Test
    @DisplayName("랜덤값에 10보다 큰 수가 들어오면 에러발생")
    void randomAbleCountChk(){
        assertThatThrownBy(() -> {new RandomNumber(11);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤값은 10보다 클수없습니다");
    }

}
