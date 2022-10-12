import domain.Car;
import domain.CarName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {


    @Test
    public void 자동차_생성처리() {
        Car car = new Car(new CarName("sunny"));
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "SunnyCar"})
    public void 자동차_생성처리_실패(String name) {
        assertThatThrownBy(() -> new Car(new CarName(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //TC 실패 수정
    @Test
    public void 자동차_정지_with_조건() {
        Car car = new Car(new CarName("sunny"));
        car.moveWithCondition(2, 5);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차_이동_with_조건() {
        Car car = new Car(new CarName("sunny"));
        car.moveWithCondition(3, 2);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
