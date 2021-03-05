package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차는 한 칸 씩 움직여야 한다.")
    void moveOneSpace() {
        int location = car.getLocation();

        car.move();

        assertThat(car.getLocation()).isEqualTo(location + 1);
    }

    @DisplayName("자동차의 이동 경로를 문자열로 표현한다")
    @ParameterizedTest(name = "{0}회 이동")
    @CsvSource({"1,-", "2,--", "3,---"})
    void getTrackOfCar(int moves, String expected) {
        for (int i = 0; i < moves; i++) {
            car.move();
        }

        assertThat(car.getTrack()).isEqualTo(expected);
    }


    @Test
    @DisplayName("자동차가 움직이지 않았을 때는 빈 문자열로 표현한다.")
    void getTrackOfCarIfNotMoved() {
        assertThat(car.getTrack()).isEmpty();
    }

}
