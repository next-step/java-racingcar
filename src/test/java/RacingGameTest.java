import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("객체를 생성하면 자동차 수 만큼 레이싱 카 객체가 생성된다.")
    void createRacingGame(Integer carCount) {
        RacingGame game = new RacingGame(carCount, 3, () -> true);

        assertEquals(carCount, game.getCars().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("움직임 조건이 만족하면 시도횟수만 큼 자동차가 움직인다.")
    void runMovesCars(Integer attempts) {
        RacingGame game = new RacingGame(3, attempts, () -> true);

        game.run();

        for (RacingCar car : game.getCars()) {
            assertEquals(attempts, car.getPosition());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("움직임 조건이 만족하지 않으면 자동차가 움직이지 않는다.")
    void runStaysCars(Integer attempts) {
        RacingGame game = new RacingGame(3, attempts, () -> false);

        game.run();

        for (RacingCar car : game.getCars()) {
            assertEquals(0, car.getPosition());
        }
    }

}