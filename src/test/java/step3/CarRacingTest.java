package step3;

import org.junit.jupiter.api.*;
import step3.*;

import static org.assertj.core.api.Assertions.*;


public class CarRacingTest {
    private CarRacing carRacing;
    @BeforeEach
    void make_racing_test() {
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.make(5);
        carRacing = CarRacing.setting(cars, new Referee(),5);
    }
    @Test
    @DisplayName("경주 게임 생성 기능")
    public void make_racing() {
        // then
        Assertions.assertNotNull(carRacing);
    }

    @Test
    @DisplayName("자동차 생성 기능")
    public void make_racing_car() {
        // given when
        CarFactory carFactory = new CarFactory();
        // then
        Cars cars = carFactory.make(5);
        assertThat(cars.isSize(5)).isTrue();
    }
    @Test
    @DisplayName("자동차 이동 기능 -> 이동 가능할 경우")
    public void can_move_car() {
        // given
        Car car = Car.create();

        // when
        car.move();

        // then
        assertThat(car).extracting("distance").isEqualTo(2);
    }

    @Test
    @DisplayName("자동자 이동 여부 판단 기능")
    public void cant_move_car() {
        // given
        Referee referee = new Referee();
        Car car = Car.create();

        //  when
        referee.judge(car);

        // then
        assertThat(car).extracting("distance").isIn(1,2);
    }

}
