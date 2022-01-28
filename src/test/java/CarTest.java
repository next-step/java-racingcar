import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    @DisplayName("전진 불가한 경우")
    void 전진_불가() {
        Car car = new Car("Jiin");
        car.moveForward(1);
        assertThat(car.getPosition()).isEqualTo("");
    }

    @Test
    @DisplayName("전진 가능한 경우")
    void 전진_가능() {
        Car car = new Car("Leah");
        car.moveForward(5);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @Test
    @DisplayName("Car 객체 생성 불가한 경우")
    void 이름_5글자_이상() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car("LeahJiin"));
    }


}
