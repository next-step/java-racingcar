package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    private static final Movement MOVEMENT = () -> 1;

    @Test
    @DisplayName("자동차는 한 칸 씩 움직여야 한다.")
    void moveOneSpace() {
        Car car = new Car(() -> 1, "test");
        int firstLocation = car.getLocation();
        int round = 5;

        for (int i = 0; i < round; i++) {
            car.move();
        }


        assertThat(car.getLocation()).isEqualTo(firstLocation + round);
    }

    @Test
    @DisplayName("이름을 반드시 입력해야 한다.")
    void throwExceptionIfCarNameIsEmpty() {

        assertAll(
            () -> assertThatThrownBy(() -> new Car(MOVEMENT, "")).isInstanceOf(CarNameException.class),
            () -> assertThatThrownBy(() -> new Car(MOVEMENT, null)).isInstanceOf(CarNameException.class)
        );
    }

    @Test
    @DisplayName("이름은 최대 다섯 글자만 허용한다.")
    void throwExceptionIfCarNameExceedFive() {
        assertThatThrownBy(() -> new Car(MOVEMENT, "Test Name")).isInstanceOf(CarNameException.class);
    }

}
