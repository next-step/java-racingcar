package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    Car car =new Car();

    @ParameterizedTest
    @ValueSource(ints={4,6,8})
    @DisplayName("이동하는 경우")
    void move_ok(int randomValue){
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints={-1,3,2})
    @DisplayName("정지하는 경우")
    void move_not_ok(int randomValue){
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    void isMove_true_test(int input){
        assertThat(car.isMove(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints ={0,2,3})
    void isMove_false_test(int input ){
        assertThat(car.isMove(input)).isFalse();
    }
}
