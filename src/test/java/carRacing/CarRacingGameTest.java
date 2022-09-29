package carRacing;

import carRacing.domain.Car;
import carRacing.domain.CarRacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    private final static int DEFAULT_POSITION = 1;
    private final static String CAR_NAMES_STRING_TO_TEST = "pobi,crong,honux";

    @Test
    @DisplayName("CarRacingGame 인스턴스를 생성했을 때 CarEntry 값이 올바른지 테스트")
    public void carRacingGameTest1() {
        CarRacingGame carRacingGame = new CarRacingGame(CAR_NAMES_STRING_TO_TEST , 3);
        assertThat(carRacingGame.getCarEntryList()).isNotNull();
        assertThat(carRacingGame.getCarEntryList().size()).isEqualTo(CAR_NAMES_STRING_TO_TEST.split(",").length);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("[랜덤 요소 존재] 모든 자동차 경주 게임이 끝난 후, 각 자동차가 움직인 횟수는 시합 횟수를 초과하지 않음을 테스트")
    public void carRacingGameTest2(int testNumber) {
        CarRacingGame carRacingGame = new CarRacingGame(CAR_NAMES_STRING_TO_TEST, testNumber);
        carRacingGame.doGame();
        for (Car car : carRacingGame.getCarEntryList()) {
            assertThat(car.getPosition() - DEFAULT_POSITION).isLessThanOrEqualTo(testNumber);
        }
    }

}