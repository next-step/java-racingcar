package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @DisplayName("차량 이름 미 입력시 예외처리 테스트")
    @NullAndEmptySource
    void noNameCarMakeExceptionTest(String carName){
        assertThatThrownBy(() ->{
            new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("차량 포지션 기준에 부합하지 않을시 (0보다 작을시) 예외처리 테스트")
    @ValueSource(ints = {-1, -2})
    void noPositionCarMakeExceptionTest(int carPosition){
        assertThatThrownBy(() ->{
            new Car("", carPosition);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("조건 충족시 차량 포지션 증가 체크 : ")
    @ValueSource(ints = {4,5,6,7,8,10})
    void moveMethodTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        Car car = new Car("랜덤카").move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("조건 미충족시 차량 포지션 증가 실패 체크 : ")
    @ValueSource(ints = {1,2,3})
    void moveMethodFailTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        Car car = new Car("랜덤카").move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isEqualTo(0);
    }
}
