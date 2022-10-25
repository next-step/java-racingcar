package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 객체 생성")
    public void 자동차_생성() {
        String[] carName = new String[4];
        List<Car> cars = CarStorage.exit(carName);
        int makedCarsCount = cars.size();
        assertThat(makedCarsCount).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차 이름 글자수 테스트")
    public void 잘못된_자동차_이름() {
        String[] carName = new String[]{"aweweee"};
        assertThatThrownBy(() -> CarValidator.nameValidator(carName)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자가 넘을 수 없습니다!");
    }

    @Test
    @DisplayName("자동차 전진 - 4 이상일 경우, 1 전진")
    public void 이동() {
        Car car = new Car("testCar");
        car.move();
        int distance = car.getDistance();
        int move = distance;
        assertTrue(move == 1 || move ==0);
    }

}
