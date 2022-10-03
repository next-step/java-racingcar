package racingcarGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 5자 초과 검증")
    public void createCar() {
        assertThatThrownBy(() -> new Car(0, "bellas"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1"}, delimiter = ':')
    @DisplayName("랜덤으로 뽑은 수가 4이상의 경우")
    public void movableCar(int chosenNumber, int expected) {
        Car result = new Car(0, "bella");
        result.move(chosenNumber);

        assertThat(result).isEqualTo(new Car(expected, "bella"));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "2:0"}, delimiter = ':')
    @DisplayName("랜덤으로 뽑은 수가 4미만의 경우")
    public void unmovableCar(int chosenNumber, int expected) {
        Car result = new Car(0, "bella");
        result.move(chosenNumber);

        assertThat(result).isEqualTo(new Car(expected, "bella"));
    }
}