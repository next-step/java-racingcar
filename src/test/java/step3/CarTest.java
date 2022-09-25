package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.util.numberGenerator.ExceptionTriggerNumberGenerator;
import step3.util.numberGenerator.FixedLowerNumberGenerator;
import step3.util.numberGenerator.FixedOverNumberGenerator;
import step3.util.numberGenerator.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach(){
        car = new Car();
    }

    @Test
    @DisplayName("Car 객체를 생성하였을 때, 움직임 횟수는 0으로 초기화 되어야 한다.")
    void CarInitTest(){
        Car car = new Car();
        assertThat(car).extracting("moveCnt").isEqualTo(0);
    }

    @Test
    @DisplayName("입력된 숫자가 4 이상인 경우 자동차는 움직인다")
    void moveCar_over4(){
        NumberGenerator fixedOverNumberGenerator = new FixedOverNumberGenerator();
        car.decideMoveOrStop(fixedOverNumberGenerator);
        assertThat(car).extracting("moveCnt").isEqualTo(1);
    }

    @Test
    @DisplayName("입력된 숫자가 4 미만인 경우 자동차는 움직이지 않는다.")
    void moveCar_lower4() {
        NumberGenerator fixedLowerNumberGenerator = new FixedLowerNumberGenerator();
        car.decideMoveOrStop(fixedLowerNumberGenerator);
        assertThat(car).extracting("moveCnt").isEqualTo(0);
    }

    @Test
    @DisplayName("게임에서 필요한 숫자 범위를 넘기면 Exception 발생")
    void numberOfRangeTest(){
        Car car = new Car();
        NumberGenerator numberGenerator = new ExceptionTriggerNumberGenerator();

        assertThatThrownBy(() -> {
            car.decideMoveOrStop(numberGenerator);
        }).isInstanceOf(RuntimeException.class);
    }
}