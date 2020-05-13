package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("UserInput을 받아오면 RacingGame 인스턴스 변수에 저장하는 테스트")
    @ParameterizedTest
    @MethodSource("mockGetUserInputMap")
    public void saveUserInputMapValues(Map<String, Integer> userInputMap) {
        RacingGame racingGame = new RacingGame();
        racingGame.setGameInformation(userInputMap);
        assertThat(racingGame.getGameTryCounts())
                .isEqualTo(userInputMap.get(UserInputMapKey.GAME_TRY_COUNTS.getKey()));
        assertThat(racingGame.getRacingCars().size())
                .isEqualTo(userInputMap.get(UserInputMapKey.CAR_COUNTS.getKey()));
    }

    private static Stream<Arguments> mockGetUserInputMap() {
        Map<String, Integer> userInputMap = new HashMap<>();
        userInputMap.put(UserInputMapKey.CAR_COUNTS.getKey(), 10);
        userInputMap.put(UserInputMapKey.GAME_TRY_COUNTS.getKey(), 10);
        return Stream.of(
                Arguments.of(userInputMap)
        );
    }

    @DisplayName("차량 대수 Input을 입력받으면 RacingCar 객체를 Input 개수만큼 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 3})
    public void makeRacingCarObjectInAccordanceWithInput(int carCounts) {
        RacingGame racingGame = new RacingGame();
        racingGame.setRacingCars(carCounts);;
        assertThat(racingGame.getRacingCars().size()).isEqualTo(carCounts);
    }

    @DisplayName("조건에 맞으면 RacingCar 객체가 움직이는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {7, 9, 5, 6})
    public void moveRacingCarObjectWhenInputIsOver4(int randomNumber) {
        RacingGame racingGame = new RacingGame();
        racingGame.setRacingCars(1);
        racingGame.moveRacingCarByRandomNumber(racingGame.getRacingCars().get(0), randomNumber);
        assertThat(racingGame.getRacingCars().get(0).getPosition())
                .isEqualTo(1);
    }
}
