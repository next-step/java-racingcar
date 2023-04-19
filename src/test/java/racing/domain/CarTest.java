package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final String DEFAULT_CAR_NAME = "kgh";

    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car(DEFAULT_CAR_NAME);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 객체가 생성되는지 확인")
    @Test
    void create_car() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 전진 이동 테스트")
    @Test
    void go_car() {
        car.go();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 자동차 객체 생성시 이름을 부여할 수 있는지 확인")
    @Test
    void create_car_with_name() {
        assertThat(car.getName()).isEqualTo(DEFAULT_CAR_NAME);
    }

}
