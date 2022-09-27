package carRacing;

import carRacing.Car;
import carRacing.CarRacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    private final static int DEFAULT_POSITION = 1;

    @Test
    @DisplayName("CarRacingGame 인스턴스가 생성됐을 때 CarEntry 값이 비어있지 않음을 테스트")
    public void carRacingGameTest1() {
        CarRacingGame carRacingGame = new CarRacingGame(5, 3);
        assertThat(carRacingGame.getCarEntryList()).isNotNull();
        assertThat(carRacingGame.getCarEntryList().size()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("모든 자동차 경주 게임이 끝난 후, 각 자동차가 움직인 횟수는 시합 횟수를 초과하지 않음을 테스트")
    public void carRacingGameTest1(int testNumber) {
        CarRacingGame carRacingGame = new CarRacingGame(testNumber, testNumber);
        carRacingGame.doGame();
        for(Car car : carRacingGame.getCarEntryList()){
            assertThat(car.getPosition() - DEFAULT_POSITION).isLessThanOrEqualTo(testNumber);
        }
    }
}