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
    @ValueSource(strings = {"0", "  0 ", "0g", "0gi", "0gir", "0giri"})
    void 자동차이름_앞뒤_공백제외_1글자_이상_5글자_이하_성공(String value) {
        assertThatNoException().isThrownBy(() -> new Car(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "0    0", "0girii"})
    void 자동차이름_앞뒤_공백제외_1글자_미만_5글자_초과_실패(String value) {
        assertThatThrownBy(() -> new Car(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 복사생성자로_생성된_복제본_변경시_원본_유지() {
        //given
        car.move(10);
        Car copy = new Car(car);

        //when
        copy.move(5);

        //then
        assertThat(car.location()).isEqualTo(10);
        assertThat(copy.location()).isEqualTo(15);
    }

    @Test
    void 자동차_거리_4이상_전진() {
        //when
        car.move(5);

        //then
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_거리_4미만_멈춤() {
        //given
        car.move(5);
        assertThat(car.location()).isEqualTo(5);

        //when
        car.move(2);

        //then
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_여러번_이동시_위치_누적() {
        //when
        car.move(5);
        car.move(2);
        car.move(8);

        //then
        assertThat(car.location()).isEqualTo(13);
    }

    @Test
    void 자동차_현재위치_반환() {
        //given
        assertThat(car.location()).isEqualTo(0);

        //when
        car.move(7);

        //then
        assertThat(car.location()).isEqualTo(7);
    }
}
