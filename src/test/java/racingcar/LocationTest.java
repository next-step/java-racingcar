package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    @DisplayName("Location 객체가 생성이 잘 되었는가?")
    @Test
    void create_car_test() {
        Location location = new Location();
        assertThat(location).isNotNull();
    }

    @DisplayName("Location 위치정보를 설정하고 가져올 수 있나?")
    @Test
    void car_set_get_location_test() {
        Location location = new Location();
        location.move();

        assertThat(1).isEqualTo(location.getLocation());
    }

    @DisplayName("전진 테스트")
    @Test
    void isGo_test() {
        RacingCar racingCar = new RacingCar("pobi", new Location());
        racingCar.canGo(5);
        assertThat(1).isEqualTo(racingCar.getCarLocation());

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar("pobi", new Location());
        racingCar.canGo(3);
        assertThat(0).isEqualTo(racingCar.getCarLocation());

    }

}
