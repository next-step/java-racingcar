package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.Car;
import step3.game.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarFactoryTest {
    @Test
    @DisplayName("주어진 개수 만큼 자동차를 생성하는지 체크한다.")
    public void createCarsTest() {
        // given
        String carName = "a,b,c";
        // when
        List<Car> cars = CarFactory.createCars(carName);
        // then
        assertThat(cars).hasSize(carName.split(",").length);
    }
    @Test
    @DisplayName("자동차 이름 구분은 ,로 이루어져야 한다.")
    public void createCarsExceptionTest() {
        // given
        String carName = "a;b";
        // when & then
        assertThatThrownBy(() -> {
            CarFactory.createCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름은 최소 2대 이상이어야 한다.")
    public void createCarsExceptionTest2() {
        // given
        String carName = "a,";
        // when & then
        assertThatThrownBy(() -> {
            CarFactory.createCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 copy가 정상적으로 이루어지는지 확인한다.")
    public void copyCarsTest() {
        // given
        List<Car> cars = List.of(new Car("a", 1), new Car("b", 2), new Car("c", 3));
        // when
        List<Car> copyCars = CarFactory.copyCars(cars);

        // then
        assertThat(copyCars).isNotSameAs(cars);
    }
}
