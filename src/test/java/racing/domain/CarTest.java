package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("0giri");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0gi", "0giri"})
    void 이름_1글자_이상_5글자_이하_성공(String value) {
        assertThatNoException().isThrownBy(() -> new Car(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0girii"})
    void 이름_1글자_미만_5글자_초과_실패(String value) {
        assertThatThrownBy(() -> new Car(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_랜덤_4이상_전진() {
        //when
        car.move(5);
        //then
        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    void 이동_랜덤_4미만_정지() {
        //when
        car.move(2);
        //then
        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    void 여러번_이동시_위치_누적() {
        //when
        car.move(5);
        car.move(2);
        car.move(8);
        //then
        assertThat(car.position()).isEqualTo(2);
    }

    @Test
    void 복사생성자_복제본_변경시_원본_유지() {
        //given
        car.move(10);
        Car copy = new Car(car);
        //when
        copy.move(5);
        //then
        assertThat(car.position()).isEqualTo(10);
        assertThat(copy.position()).isEqualTo(15);
    }
}
