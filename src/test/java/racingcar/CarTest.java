package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @ValueSource(strings = {"sonata", "k5", "genesis"})
    @ParameterizedTest
    @DisplayName("차가 움직이면 값이 현재위치와 같거나 이상의 값을 가질 수 있다.")
    void moveTest(String carNames){
        Car car = Car.newInstance(carNames);
        int result = car.move();
        assertThat(result).isGreaterThanOrEqualTo(car.getPosition());
    }

    @ValueSource(strings = {"sonata", "k5", "genesis"})
    @ParameterizedTest
    @DisplayName("기본 Car 생성 메소드 테스트")
    void newInstanceTest(String carNames){
        int expected = 0;
        Car car = Car.newInstance(carNames);

        assertThat(car.getPosition()).isEqualTo(expected);
        assertThat(car.getMovableStrategy()).isExactlyInstanceOf(RandomMovableStrategy.class);
    }

    @Test
    @DisplayName("Car의 movableStrategy가 NULL 일 때 IllegalArgumentException이 발생한다.")
    void carMovableStrategyNullTest(){
        Car car = Car.newInstance("sonata");
        car.setMovableStrategy(null);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.move());
    }

    @ValueSource(ints = {-1})
    @ParameterizedTest
    @DisplayName("Car의 위치가 0보다 작다면 IllegalArgumentException이 발생한다. ")
    void carPositionIsLessThanZeroTest(int position){
        Car car = Car.newInstance("test");
        car.setPosition(position);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.move());
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Car를 생성할 때 이름이 없거나 null이면 IllegalArgumentException이 발생한다.")
    void NullAndEmptyNameTest(String carName){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.newInstance(carName));
    }
}
