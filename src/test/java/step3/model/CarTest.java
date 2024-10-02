package step3.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    void 자동차_생성() {
        Car car = new Car("hwan2");
        assertThat(car.getMovement()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void 임의의_값이_4_이상이면_전진한다(int value) {
        Car car = new Car("hwan2");
        car.moveOrStop(value);
        assertThat(car.getMovement()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void 임의의_값이_4_미만이면_전진하지않는다(int value) {
        Car car = new Car("hwan2");
        car.moveOrStop(value);
        assertThat(car.getMovement()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hwan22"," "})
    void 자동차_이름의_길이는_1이상_5이하가_아니면_예외발생(String value){
       assertThatThrownBy(() -> new Car(value));
    }
}
