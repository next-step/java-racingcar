package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;
import racingcar.strategy.MovableNumberGeneratorStrategy;
import racingcar.strategy.NonMovableNumberGeneratorStrategy;
import racingcar.strategy.RandomNumberGeneratorStrategy;


@DisplayName("Car 객체 테스트")
public class CarTest {

    @DisplayName("랜덤값을 구한 후 전진 또는 멈출수 있다")
    @Test
    void 차의_움직임_테스트() {
        Car car = new Car("korea");
        car.move(new RandomNumberGeneratorStrategy());
        Assertions.assertThat(car.findCarPoint()).isBetween(0, 1);
    }

    @DisplayName("차가 움직인 경우 스코어(위치)는 1이다")
    @Test
    void 차의_전진_테스트() {
        Car car = new Car("korea");
        car.move(new MovableNumberGeneratorStrategy());
        Assertions.assertThat(car.findCarPoint()).isEqualTo( 1);
    }

    @DisplayName("차가 정지한 경우 스코어(위치)는 0이다")
    @Test
    void 차의_정지_테스트() {
        Car car = new Car("korea");
        car.move(new NonMovableNumberGeneratorStrategy());
        Assertions.assertThat(car.findCarPoint()).isEqualTo( 0);
    }

    @Test
    @DisplayName("자동차를 생성할때 이름 5자리를 초과하면 예외가 발생한다")
    void 자동차_이름_예외_테스트() {
        Assertions.assertThatThrownBy(() -> new Car(1, "UnitedKingdom"))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과 할 수 없습니다");
    }
    
}
