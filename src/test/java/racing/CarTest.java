package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤숫자_4이상_9이하일경우_전진(int number) {
        Car car = new Car(0);
        car.move(number);

        assertThat(car.getNowPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void 랜덤숫자_4미만_9초과일경우_전진_실패(int number) {
        int position = 5;
        Car car = new Car(position);
        car.move(number);

        assertThat(car.getNowPosition()).isEqualTo(position);
    }


}
