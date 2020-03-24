package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("Car 객체가 잘 생성되는 지 테스트")
    void newCarTest() {
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Car 이름이 잘 초기화 되는지 테스트")
    void initCarName() {
        assertThat(car.getCarName()).isEqualTo("test");
    }

    @Test
    @DisplayName("Car 객체 처음 생성시 위치(position)은 0이다.")
    void initCarPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 객체는 한번 전진하면 position이 1씩 증가해야 한다.")
    void moveCarTest() {
        int roundTime = 1;
        car.move(1);
        car.move(2);

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
