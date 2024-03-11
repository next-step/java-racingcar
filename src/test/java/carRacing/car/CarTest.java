package carRacing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차는 값이 4 이상일 때, 위치를 1 이동한다.")
    public void randomNumberIsGreaterThanOrEqualFourThenUpdateCarPosition() throws Exception{
        Car car = new Car();
        car.updatePosition(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 값이 3 이하일 때, 움직이지 않는다.")
    public void randomNumberIsLessThanFourThenNotUpdateCarPosition() throws Exception{
        Car car = new Car();
        car.updatePosition(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 수 없다.")
    void carNameCanNotBeGraterThanFive() throws Exception {
        String name = "Hermione";
        assertThatThrownBy(()->{
            Car.of(name);
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessageContaining("이름은 5자를 초과할 수 없습니다.");
    }

}
