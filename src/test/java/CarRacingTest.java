import static org.assertj.core.api.Assertions.*;

import carRacing.Car;
import carRacing.CarNumber;
import carRacing.Name;
import carRacing.TryNumber;
import carRacing.Winner;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingTest {
    @Test
    @DisplayName("자동차 객체 생성 시 위치값은 0이다")
    void carObjectInitialValue() {
        Car car = new Car(new Name("test"));
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 전진한다")
    @ValueSource(ints = {4, 5})
    void carMoveForward(int number) {
        Car car = new Car(new Name("test"));
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4미만이면 전진하지 않는다")
    @ValueSource(ints = {2, 3})
    void carNotMoveForward(int number) {
        Car car = new Car(new Name("test"));
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("CarNumber, TryNumber는 1이상의 정수만 입력받을 수 있다")
    void inputVONotValid() {
        assertThatThrownBy(() -> {
            CarNumber carNumber = new CarNumber(0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 이상의 정수만 입력 가능합니다.");
        assertThatThrownBy(() -> {
            TryNumber carNumber = new TryNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 이상의 정수만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 객체 생성 시 이름을 부여할 수 있다")
    @ValueSource(strings = "차차차")
    void carObjectHaveName(String name) {
        Car car = new Car(new Name("차차차"));
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("이름은 5자를 초과할 수 없다")
    @ValueSource(strings = "블루베리스무디")
    void nameValidation(String name) {
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자를 초과할 수 없습니다.");
    }
    @Test
    @DisplayName("우승자를 찾는다")
    void findWinner() {
        Car car = new Car(new Name("자동차"));
        car.move(6);
        Car car1 = new Car(new Name("자동차1"));
        Car car2 = new Car(new Name("자동차2"));
        List<Car> cars = Arrays.asList(car, car1, car2);
        Winner winners = new Winner(cars);
        List<Car> winnersCar = winners.findWinner();
        assertThat(winnersCar).hasSize(1);
        assertThat(winnersCar.get(0)).isEqualTo(car);

    }
}
