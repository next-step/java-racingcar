package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void isMove(){
        assertThat(car.isMove(3)).isEqualTo(false);
    }
}
