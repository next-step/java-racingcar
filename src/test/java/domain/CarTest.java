package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class CarTest {
    String carName;
    int startDistance;

    @BeforeEach
    void setUp() {
        carName = "AAA";
        startDistance = 0;
    }

    @Test
    void getName() {
        //given
        Car car = new Car(carName, startDistance);

        //when
        String getName = car.getName();

        //then
        Assertions.assertThat(getName).isEqualTo(carName);
    }

    @Test
    void getDistance() {
        //given
        Car car = new Car(carName, startDistance);

        //when
        int getDistance = car.getDistance();

        //then
        Assertions.assertThat(getDistance).isEqualTo(startDistance);
    }

    @Test
    void updateDistance() {
        //given
        Car car = new Car(carName, startDistance);

        //when
        car.updateDistance();

        //then
        Assertions.assertThat(car.getDistance()).isNotEqualTo(startDistance);
    }

    @Test
    @DisplayName("이름이 5글자 이하 정상")
    void validateNameLengthCheckSuccess() {
        //Given
        Car car = new Car(carName, startDistance);

        //when
        car.validateNameLengthCheck(carName);
    }

    @Test
    @DisplayName("이름이 5글자 초과시에 오류 발생")
    void validateNameLengthCheckFail() throws Exception {
        //given
        String newName = "ABCDEFG";
        Car car = new Car("ABCDEFG", startDistance);

        //when
        IllegalArgumentException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> car.validateNameLengthCheck(newName));

        Assertions.assertThat(e.getMessage()).isEqualTo("car name is too long");
    }
}