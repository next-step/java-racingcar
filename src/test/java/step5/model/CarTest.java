package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    Car car = new Car("temp");

    @DisplayName("이동하거나 정지하는 경우")
    @ParameterizedTest
    @CsvSource(value ={"4:1","9:1","3:0","1:0"},delimiter =':')
    void move(int randomValue, int moveCount){
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void isMove_true_test(int input) {
        assertThat(car.isMove(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void isMove_false_test(int input) {
        assertThat(car.isMove(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void Name_공백인경우(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(names);
        }).withMessageContaining("Name length error");
    }

    @Test
    void Name_널인경우() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("널값은 입력할 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"zorba87", "lhbtest"})
    void Name_길이통과_안되는경우(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(names);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Messi", "SonHM", "zorba"})
    @DisplayName("이름에 문제가 없는 경우")
    void 이름이_정상적인경우(String names) {
        assertThat(new Car(names));
    }


}
