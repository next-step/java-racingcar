package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar racingCar;
    private List<RacingCar> madeRacingCars;

    @BeforeEach
    void initCars() {
        List<String> carNames = Arrays.asList("aCar", "bCar", "cCar", "dCar");

        racingCar = new RacingCar("aCar");
        madeRacingCars = RacingCar.setRacingCars(carNames);
    }

    @Test
    @DisplayName("레이싱 경기를 할 자동차 1대를 생성한다.")
    void makeOneRacingCar() {
        RacingCar racingCar = new RacingCar("aCar");

        assertThat(racingCar.getCarName()).isEqualTo("aCar");
        assertThat(racingCar.getCarDist()).isZero();
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
        int afterDist;

        MoveStrategy moveStrategy = () -> 5;

        racingCar.moveCar(moveStrategy);

        afterDist = racingCar.getCarDist();

        assertEquals(1, afterDist);
    }

    @Test
    @DisplayName("랜덤한 값이 MOVABLE보다 작으면, 자동차의 dist가 움직이지 않는다.")
    void moveNotCar() {
        int afterDist;

        MoveStrategy moveStrategy = () -> 3;

        racingCar.moveCar(moveStrategy);

        afterDist = racingCar.getCarDist();

        assertEquals(0, afterDist);
    }
}