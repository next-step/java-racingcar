package racingCar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domain.Car;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car = new Car("test");

    @Test
    public void 랜덤값_4이상이면_전진() {
        car.play(createRandom(4));
        assertThat(car.getPos()).isEqualTo(1);
    }

    @Test
    public void 랜덤값_4미만이면_멈출() {
        car.play(createRandom(3));
        assertThat(car.getPos()).isEqualTo(0);
    }

    private Random createRandom(int value) {
        return new Random() {
            public int nextInt(int bound) {
                return value;
            }
        };
    }

    @ParameterizedTest
    @ValueSource(strings = {"testname", "thisistest"})
    void 자동차_이름_5글자_초과(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "conan"})
    void 자동차_이름_5글자_이하(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
