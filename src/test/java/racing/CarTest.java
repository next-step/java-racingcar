package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤숫자_4이상_9이하일경우_전진(int number) {
        Car car = new Car(0, "test");
        car.move(number);

        assertThat(car.getNowPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void 랜덤숫자_4미만_9초과일경우_전진_실패(int number) {
        int position = 5;
        Car car = new Car(position, "test");
        car.move(number);

        assertThat(car.getNowPosition()).isEqualTo(position);
    }

    @Test
    void 자동차_이름_5자_초과일경우_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("CarName"))
                .withMessageContaining("자동차 이름은 5자 이하로 가능합니다.");
    }

    @Test
    void 자동차_이름_공백일경우_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(""))
                .withMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름_5자이내일경우_오류_미발생() {
        assertDoesNotThrow(() -> new Car("test"));
    }

}
