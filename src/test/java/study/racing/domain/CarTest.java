package study.racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    @NullAndEmptySource
    @ParameterizedTest
    void 이름이_null_또는_빈값이면_예외발생(String name){
        assertThatThrownBy(() -> new Car(name, ""))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void car_생성_성공(){
        Car car = new Car("car1", "");
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getPosition()).isEqualTo("");
    }

    @Test
    void 이름이_5자_초과하면_예외발생(){
        assertThatThrownBy(() -> new Car("car12345", ""));
    }

}