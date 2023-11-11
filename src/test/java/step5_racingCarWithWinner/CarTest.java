package step5_racingCarWithWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5_racingCarWithWinner.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    void createCar(){
        String name = "보리차붕붕";
        assertThat(new Car(name).carName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void nameLength(){
        assertThatThrownBy(() -> new Car("보리차보리차"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.")
    void printCarInfo(){
        assertThat(new Car("루돌프").toString()).contains("루돌프");
    }

    @Test
    @DisplayName("자동차는 한칸 전진 할 수 있다. 전진하면 distance에 '-'가 하나 추가된다.")
    void carForward(){
        Car car = new Car("루돌프");
        car.forward();
        assertThat(car.carDistance()).isEqualTo("-");
    }

}
