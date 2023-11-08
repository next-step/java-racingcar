import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;


public class CarRacingGameTest {
    private CarRacingGame carRacingGame;
    @BeforeEach
    void make_racing_test() {
        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.create(5, 5);
        carRacingGame = CarRacingGame.gameSetting(cars);
    }
    @Test
    @DisplayName("경주 게임 생성 기능")
    public void make_racing() {
        // then
        Assertions.assertNotNull(carRacingGame);
    }

    @Test
    @DisplayName("자동차 생성 기능")
    public void make_racing_car() {
        // given when
        CarFactory carFactory = new CarFactory();
        // then
        Cars cars = carFactory.create(5,5);
        assertThat(cars.isSize(5)).isTrue();
    }
    @Test
    @DisplayName("자동차 이동 기능 -> 이동 가능할 경우")
    public void can_move_car() {
        // given
        Car car = Car.create(1);

        // when
        car.move();

        // then
        assertThat(car.canMove()).isFalse();
    }

    @Test
    @DisplayName("자동자 이동 여부 판단 기능")
    public void cant_move_car() {
        // given
        Referee referee = new Referee();
        Car car = Car.create(1);

        //  when
        referee.judge(car);

        // then
        assertThat(car.canMove()).isTrue();
    }

}
