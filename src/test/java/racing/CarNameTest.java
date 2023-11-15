package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarName;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @DisplayName("5글자 이하의 이름을 전달하면 자동차 이름 객체를 생성한다.")
    @Test
    void createCarNameTest() {
        String name = "name";
        CarName carName = new CarName(CarName.checkCarName(name).getName());
        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("5글자를 초과한 이름을 전달하면 IllegalException을 던진다.")
    @Test
    void createCarNameTestException1() {
        assertThatThrownBy(() -> new CarName(CarName.checkCarName("다섯글자넘어간이름").getName()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("빈 문자를 전달하면 IllefalException을 던진다.")
    @Test
    void createCarNameTestException2() {
        assertThatThrownBy(() -> new CarName(CarName.checkCarName("").getName()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1자 이상이여야 합니다.");
    }
}
