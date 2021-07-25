package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @DisplayName("자동차 이름 추가")
    @Test
    void setCarNameTest(){
        String name = "car";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 길이가 5가 넘으면 에러처리")
    @Test
    void carNameExceptionTest(){
        String errorName = "HGcar123";
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Car(errorName)
        ).withMessageContaining("5글자 초과");
    }

    @DisplayName("차 대소 비교하기 (포지션 기준)")
    @Test
    void compareCarsTest(){
        Car car1 = new Car("car1",10);
        Car car2 = new Car("car2",5);

        assertThat(car1.compareTo(car2) > 0).isEqualTo(true);
    }


}