package ThirdStep;

import ThirdStep.domain.model.Car;
import ThirdStep.domain.model.request.CarRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private CarRequest carRequest;

    @BeforeEach
    void setCarRequest() {
        carRequest = new CarRequest("hello_world");
    }

    @Test
    @DisplayName("5글자가 넘는 이름으로 Car를 생성하려하면 에러가 발생한다.")
    void create_car_test() {
        assertThatThrownBy(() -> new Car(carRequest)).isInstanceOf(RuntimeException.class);
    }
}
