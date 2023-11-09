package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car;

    @BeforeEach
    void Car_객체_생성() {
        car = new Car("test");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("전진 테스트")
    void 전진(int number) {
        Car car = new Car();
        int initPosition = car.currentPosition();

        car.move(number);

        assertThat(car.currentPosition()).isEqualTo(initPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("정지 테스트")
    void 정지(int number) {
        Car car = new Car();
        int initPosition = car.currentPosition();

        car.move(number);

        assertThat(car.currentPosition()).isEqualTo(initPosition);
    }


    @DisplayName("생성자 테스트")
    @Test
    void Car_생성자_멤버변수() {
        assertThat(car.carName()).isEqualTo("test");
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이름 길이")
    @Test
    void 자동차_이름_길이체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("InvalidNameTest");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

}
