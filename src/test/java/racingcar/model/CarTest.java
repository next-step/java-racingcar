package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Motor motor;

    @BeforeEach
    void setup() {
        motor = new TesterMotor();
    }

    @DisplayName("car 생성자 테스트")
    @Test
    void car() {
        Car car = new Car(motor);
        assertThat(car).isEqualToComparingFieldByField(new Car(motor));
    }

    @DisplayName("move() 테스트 : position이 +1 증가하는지 확인")
    @Test
    void move() {
        Car car = new Car(motor); // postition 초기값은 0
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
