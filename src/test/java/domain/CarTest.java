package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class CarTest {
    String carName;

    @BeforeEach
    void setUp() {
        carName = "AAA";
    }

    @Test
    void getName() {
        //given
        Car car = new Car(carName);

        //when
        String getName = car.getName();

        //then
        Assertions.assertThat(getName).isEqualTo(carName);
    }

    @Test
    void getDistance() {
        //given
        Car car = new Car(carName);

        //when
        int getDistance = car.getDistance();

        //then
        Assertions.assertThat(getDistance).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4이상이라면 자동차 move 성공")
    void moveSuccess() {
        //given
        Car car = new Car(carName);

        //when
        car.move(() -> true);

        //then
        Assertions.assertThat(car.getDistance()).isNotEqualTo(0);
    }


    @Test
    @DisplayName("랜덤 값이 3이하라면 자동차 move 실패")
    void moveFail() {
        //given
        Car car = new Car(carName);

        //when
        car.move(() -> false);

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 5글자 이하 정상")
    void validateNameLengthCheckSuccess() {
        Assertions.assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 5글자 초과시에 오류 발생")
    void validateNameLengthCheckFail() {
        //given
        String longName = "ABCDEFG";

        //when, then
        Assertions.assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name is too long");
    }
}