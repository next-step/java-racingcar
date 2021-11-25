package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("name String 초기값으로 Car 객체를 생성한다. 자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"joy", "happy", "love"})
    public void create(String name) {
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getCarName()).isInstanceOf(CarName.class);
        assertThat(car.getCarName().getName()).isEqualTo(name);
        assertThat(car.getCarPosition()).isInstanceOf(CarPosition.class);
        assertThat(car.getCarPosition().getPosition()).isEqualTo(0);
    }

    @DisplayName("name과 position 초기값으로 Car 객체를 생성한다. 자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"joy, 0", "happy, 1", "love, 3"})
    public void createWithPosition(String name, int position) {
        // when
        Car car = new Car(name, position);

        // then
        assertThat(car.getCarName()).isInstanceOf(CarName.class);
        assertThat(car.getCarName().getName()).isEqualTo(name);
        assertThat(car.getCarPosition()).isInstanceOf(CarPosition.class);
        assertThat(car.getCarPosition().getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차 이름이 blank 이거나 5자를 초과한 경우 exception을 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "happyNow", "loveYourself"})
    public void nameArgumentException(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name length must be between 1 and 5");
    }
}
