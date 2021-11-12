package carracingwinner.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void validateNameOkTest() {
        String okName = "pobi";

        Car okCar = new Car(okName);

        assertThat(okCar.getName()).isEqualTo(okName);
    }

    @Test
    void validateNameFailTest() {
        String failName = "pobi!!";

        assertThatThrownBy(() -> new Car(failName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 ")
                .hasMessageContaining("자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void moveTest(int random, int position) {
        Car car = new Car("pobi");

        car.move(random);

        assertThat(car.getPosition().getIntValue()).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,0,''", "kim,1,-", "lee,2,--"})
    void showCurrentStateTest(String name, int position, String state) {
        Car car = new Car(name, new Position(position));

        assertThat(car.showCurrentState()).isEqualTo(name + " : " + state);
    }

}
