package step4.unit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.car.game.Car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"t","te","tes","test","test1"})
    void 자동차생성_이름_5자이하(String input) {
        assertThatCode(() -> new Car(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"master","coffee","macbook","monitor","keyboard"})
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
}
