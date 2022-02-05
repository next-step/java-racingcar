package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class RacingCarTest {

    private List<RacingCar> madeRacingCars;

    @BeforeEach
    @DisplayName("테스트에 필요한 자동차들을 생성한다.")
    void initCars() {
        List<String> carNames = Arrays.asList("aCar", "bCar", "cCar", "dCar");

        madeRacingCars = RacingCar.setRacingCars(carNames);
    }

    @Test
    @DisplayName("레이싱 경기를 할 자동차들을 생성한다.")
    void makeRacingCars() {
        assertThat(madeRacingCars.get(0)
            .getCarName()).isEqualTo("aCar");
    }

    @Test
    @DisplayName("랜덤한 값이 MOVABLE보다 크면, 자동차의 dist가 1 증가한다.")
    void moveCar() {
        int currentDist = madeRacingCars.get(0).getCarDist();
        int afterDist;
        int graterThanMovable = 5;

        madeRacingCars.get(0).moveCar(graterThanMovable);

        afterDist = madeRacingCars.get(0).getCarDist();

        assertNotEquals(currentDist, afterDist);

        assertEquals(1, afterDist);
    }

    @Test
    @DisplayName("생성한 자동차의 이름을 알 수 있다.")
    void getCarName() {
        assertThat(madeRacingCars.get(0)
            .getCarName()).isEqualTo("aCar");
    }

    @Test
    @DisplayName("생성한 자동차의 이동한 거리를 알 수 있다.")
    void getCarDist() {
        assertThat(madeRacingCars.get(0)
            .getCarDist()).isEqualTo(0);
    }
}