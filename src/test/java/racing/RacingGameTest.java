package racing;

import edu.next.racing.domain.Car;
import edu.next.racing.domain.RacingGame;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameTest {

    private String[] carArray = {"test1","test2"};
    private RacingGame racingGame = new RacingGame(carArray, 2);
    private List<Car> cars;

    @BeforeEach
    void setRacing() {
        cars = racingGame.execute();
    }

    @DisplayName("자동차 객체 생성 테스트")
    @Test
    void racingGameCarsTest() {
        assertThat(cars).hasSize(carArray.length);
    }

    @DisplayName("우승 자동차 객체 확인 테스")
    @Test
    void racingGameWinnerTest() {
        cars = racingGame.getWinner();
        int winnerPosition = cars.get(0).getPosition();
        cars.forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(winnerPosition);
        });
    }
}
