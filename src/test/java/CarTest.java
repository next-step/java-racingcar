import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("자동차 메소드 테스트")
class CarTest {

    @Test
    @DisplayName("자동차를 생성합니다")
    void create_car() {
        //given
        String carName = "car1";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("숫자가 4보다 같거나 크면 앞으로 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void move_greater_equal_four(int input) {
        Car car = new Car("a");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @DisplayName("숫자가 4보다 작으면 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void move_less_four(int input) {
        Car car = new Car("a");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}