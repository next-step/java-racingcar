package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {


    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        Cars cars = Cars.makeCarList(10);
        assertThat(cars.getList()).hasSize(10);
    }

    @Test
    @DisplayName("자동차가 없을 시 에러발생")
    void carNullchk(){
        assertThatThrownBy(() -> {new Cars(new ArrayList<>());})
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("자동차를 생성해주세요");
    }

    @Test
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(){
        Car car = new Car();
        car.move(() -> true);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자가 들어오면 정지")
    void carStop(){
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("인풋값에 음수가 들어오면 에러발생")
    void negativeChk(){
            assertThatThrownBy(() -> {new Number(-1);})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수가 들어왔습니다");
    }
}
