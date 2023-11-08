import org.junit.jupiter.api.*;

import java.util.List;

public class CarRacingGameTest {


    @Test
    @DisplayName("경주 게임 생성 기능")
    public void make_racing() {
        // given when
        CarRacingGame carRacingGame = CarRacingGame.start(5,5);
        // then
        Assertions.assertNotNull(carRacingGame);
    }

    @Test
    @DisplayName("자동차 생성 기능")
    public void make_racing_car() {
        // given when
        CarFactory carFactory = new CarFactory();
        // then
        List<Car> cars = carFactory.create(5,5);
        Assertions.assertEquals(5,cars.size());
    }
    @Test
    @DisplayName("자동차 이동 기능 -> 이동 가능할 경우")
    public void can_move_car() {
        // given when
        CarFactory carFactory = new CarFactory();
        // then
    }

    @Test
    @DisplayName("자동차 이동 기능 -> 이동 불가능한 경우")
    public void cant_move_car() {
        // given when
        CarFactory carFactory = new CarFactory();
        // then
    }

}
