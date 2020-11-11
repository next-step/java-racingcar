package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("sehan");
    }

    @Test
    @DisplayName("MoveCondition 이 false 면 이동하지 않는다")
    void noMoving(){
        car.moveIf(() -> false );

        assertThat(CarState.of(car).getMovingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("MoveCondition 이 true 면 이동한다")
    void moving(){
        car.moveIf(() -> true);
        car.moveIf(() -> true);
        car.moveIf(() -> true);

        assertThat(CarState.of(car).getMovingDistance()).isEqualTo(3);
    }

    @Test
    @DisplayName("MoveCondition 에 따라 이동하거나 이동하지 않거나 한다")
    void moving_and_nomoving(){
        car.moveIf(() -> true);
        car.moveIf(() -> false);
        car.moveIf(() -> true);

        assertThat(CarState.of(car).getMovingDistance()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자를 초과하면 Exception 을 던진다")
    @ValueSource(strings = {"123456", "1234567", "12345678"})
    void nameLength(String name){
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 Null 이거나 Blank 면 Exception 을 던진다")
    @NullAndEmptySource
    void nameLength2(String name){
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(InvalidCarNameException.class);
    }


}