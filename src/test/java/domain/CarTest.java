package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("이동이 성공하면, distance 가 상승한다.")
    void distanceTest() {
        Car car = new Car("name");

        car.attemptMove(true);

        assertThat(car.getCarCurrentDistance()).isEqualTo(1);
    }


    @ParameterizedTest(name = "생성된 자동차는 이름을 가지고 있다.")
    @ValueSource(strings = "Ethan")
    void nameCheck(String name) {

        Car car = new Car(name);

        assertThat(car.getCarName()).isEqualTo("Ethan");
    }

}
