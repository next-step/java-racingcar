package racinggame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;
import racinggame.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"car1:1:0", "car2:4:1"}, delimiter = ':')
    void 자동차가_조건에따라_이동한다(String name, int inputRandomNumber, int inputDistance) {
        //given
        Car car = new Car(name);

        //when
        car.move(inputRandomNumber);

        //then
        assertThat(car.distance()).isEqualTo(inputDistance);
        assertThat(car.getCarName()).isEqualTo(new CarName(name));
    }

    @Test
    void 자동차가_이름은_5글자_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}