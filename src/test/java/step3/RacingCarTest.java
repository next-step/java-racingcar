package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RacingCarTest {

    Car car;
    AlwaysMoveStrategy alwaysMoveStrategy;

    @BeforeEach
    void beforeEach() {
        alwaysMoveStrategy = new AlwaysMoveStrategy();
        car = new Car(alwaysMoveStrategy);
    }

    @Test
    public void 자동차_객체를_생성하고_현재_위치를_조회하면_0이_나온다() {
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    public void random값이_4이상이면_현재_위치에서_한칸_전진한다() {
        car.moveForwardOnChance();
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    public void 자동차_경주_시작_때_입력받은_수_만큼_자동차가_생성된다() {
        CarRacing carRacing = new CarRacing(3, alwaysMoveStrategy);
        int carCount = carRacing.getCars().size();

        assertThat(carCount).isEqualTo(3);
    }

    @Test
    public void 입력받은_수_만큼_이동을_시도한다() {
        CarRacing carRacing = new CarRacing(3, alwaysMoveStrategy);

        for (int i = 0; i < 3; i++) {
            carRacing.moveCars();
        }

        int lastLocation = carRacing.getCars().get(0).getCurrentLocation();
        assertThat(lastLocation).isEqualTo(3);
    }

    @Test
    public void getCars_반환된_리스트는_불변이어야_한다() {
        CarRacing carRacing = new CarRacing(3, alwaysMoveStrategy);
        List<Car> cars = carRacing.getCars();

        assertThrows(UnsupportedOperationException.class, () -> cars.add(new Car(alwaysMoveStrategy)));
    }
}
