package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("Position 객체가 생성이 잘 되었는가?")
    @Test
    void create_car_test() {
        Position position = new Position();
        assertThat(position).isNotNull();
    }

    @DisplayName("Position 위치정보를 설정하고 가져올 수 있나?")
    @Test
    void car_set_get_location_test() {
        Position position = new Position();
        position.setLocation("--");

        assertThat(2).isEqualTo(position.getLocation().length());
    }

    @DisplayName("전진 테스트")
    @Test
    void isGo_test() {
        RacingCar racingCar = new RacingCar(new Position());
        String result = racingCar.isGo(5);
        assertThat(result).isEqualTo("-");

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar(new Position());
        String result = racingCar.isGo(3);
        assertThat(result).isEqualTo("");
    }

}
