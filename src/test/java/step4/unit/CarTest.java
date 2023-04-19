package step4.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"t", "te", "tes", "test", "test1"})
    void 자동차생성_이름_5자이하(String input) {
        assertThatCode(() -> new Car(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"master", "coffee", "macbook", "monitor", "keyboard"})
    void 자동차생성_이름_5자를_초과할수없음(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름은_비어있거나_널일수없음(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 첫번째_자동차가_승자() {
        Cars cars = new Cars(4);

        for (int i = 0; i < cars.cars().size(); i++) {
            moveCar(cars.cars().get(i), 5 - i);
        }

        assertThat(cars.winners()).hasSize(1);
        assertThat(cars.winners().get(0)).isEqualTo(cars.cars().get(0).name());
    }

    private void moveCar(Car car1, int location) {
        IntStream.range(0, location)
                .forEach(value -> car1.move(9));
    }
}
